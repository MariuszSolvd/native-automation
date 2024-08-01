package com.solvd;

import com.solvd.mapper.ProductMapper;
import com.solvd.model.ProductData;
import com.solvd.pages.common.HomePage;
import com.solvd.pages.common.app.*;
import com.solvd.pages.common.app.Menu;
import com.solvd.pages.common.app.component.Product;

import com.zebrunner.carina.utils.R;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AppTest extends TestBase {

    @Test(testName = "TC1")
    public void shouldOpenSwagLabsApp() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
    }

    @Test(testName = "TC2")
    public void shouldLogin() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
        loginPage.login(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        ProductPage productPage = initPage(getDriver(), ProductPage.class);
        productPage.assertPageOpened();
    }

    @Test(testName = "TC3")
    public void shouldNotLogin() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
        loginPage.login(R.TESTDATA.get("incorrect_user"), R.TESTDATA.get("incorrect_password"));
        assertTrue(loginPage.isErrorVisible(), "Error is not visible");
    }

    @Test(testName = "TC4")
    public void scrollProductPage() {
        ProductPage productPage = successfulLogin();
        productPage.assertPageOpened();
        productPage.swipeToLastProduct();
        assertTrue(productPage.isLastProductVisible(), "Last product is not visible");
    }

    @Test(testName = "TC5")
    public void verifyProductDetails() {
        ProductPage productBasePage = successfulLogin();
        productBasePage.assertPageOpened();
        Product randomProduct = productBasePage.getRandomProduct();
        ProductData productPicked = ProductMapper.getProduct(randomProduct);
        ProductDetailsPage productDetailsPage = randomProduct.clickOnProduct();
        ProductData productDetails = ProductMapper.getProduct(productDetailsPage);
        assertEquals(productPicked, productDetails, "Product picked does not have same data as product page");

    }

    @Test(testName = "TC6")
    public void verifyAddProductInCart() {
        ProductDetailsPage productDetailsPage = pickRandomProduct();
        productDetailsPage.addToCart();
        ProductData addedProduct = ProductMapper.getProduct(productDetailsPage);
        CartPage cartPage = productDetailsPage.getHeader().clickCartButton();
        ProductData cartProduct = ProductMapper.getProduct(cartPage.getProducts().getFirst());
        assertEquals(addedProduct, cartProduct, "Product added to cart is not the same");
    }

    @Test(testName = "TC7")
    public void verifyRemoveProductFromCart() {
        ProductDetailsPage productDetailsPage = pickRandomProduct();
        productDetailsPage.addToCart();
        ProductData addedProduct = ProductMapper.getProduct(productDetailsPage);
        CartPage cartPage = productDetailsPage.getHeader().clickCartButton();
        ProductData cartProduct = ProductMapper.getProduct(cartPage.getProducts().getFirst());
        assertEquals(addedProduct, cartProduct, "Product added to cart is not the same");
        cartPage.getProducts().getFirst().clickRemove();
        assertTrue(cartPage.getProducts().isEmpty(), "Product was not removed");
    }

    @Test(testName = "TC8")
    public void checkoutWithValidInformation() {
        CartPage cartPage = pickRandomProductAndVerifyCart();
        ProductData cartProduct = ProductMapper.getProduct(cartPage.getProducts().getFirst());
        CheckoutInfoPage checkoutInfoPage = cartPage.clickCheckout();
        checkoutInfoPage.fillData(R.TESTDATA.get("correct_name"),
                R.TESTDATA.get("correct_lastname"), R.TESTDATA.get("correct_code"));
        CheckoutOverviewPage checkoutOverviewPage = initPage(getDriver(), CheckoutOverviewPage.class);
        ProductData checkoutProduct = ProductMapper.getProduct(checkoutOverviewPage.getProducts().getFirst());
        assertEquals(cartProduct, checkoutProduct, "Products are not the same");
        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickFinishButton();
        checkoutCompletePage.assertPageOpened();
    }

    @Test(testName = "TC9")
    public void checkoutWithBlankInformation() {
        CartPage cartPage = pickRandomProductAndVerifyCart();
        CheckoutInfoPage checkoutInfoPage = cartPage.clickCheckout();
        checkoutInfoPage.clickContinue();
        assertTrue(checkoutInfoPage.isErrorVisible(), "Error message is not visible");

    }

    @Test(testName = "TC10")
    public void shouldLogout() {
        ProductPage productPage = successfulLogin();
        Menu menu = productPage.getHeader().clickMenuButton();
        LoginPage loginPage = menu.clickLogout();
        loginPage.assertPageOpened();
    }

    @AfterTest
    public void closeApp() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        homePage.turnOffApp();
    }
}
