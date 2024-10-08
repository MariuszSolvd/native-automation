package com.solvd;

import com.solvd.exception.ScreenshotFailedException;
import com.solvd.mapper.ProductMapper;
import com.solvd.model.ProductData;
import com.solvd.pages.common.HomePage;
import com.solvd.pages.common.app.*;
import com.solvd.pages.common.app.Menu;
import com.solvd.pages.common.app.component.Product;
import com.solvd.service.LoginService;
import com.solvd.service.ProductService;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.registrar.Screenshot;
import com.zebrunner.carina.core.AbstractTest;

import com.zebrunner.carina.utils.R;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AppTest extends AbstractTest {

    @Test(testName = "TC1")
    @TestCaseKey("ANDT-2")
    public void shouldOpenSwagLabsApp() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
    }

    @Test(testName = "TC2")
    @TestCaseKey("ANDT-3")
    public void shouldLogin() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
        loginPage.login(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        ProductPage productPage = initPage(getDriver(), ProductPage.class);
        productPage.assertPageOpened();
    }

    @Test(testName = "TC3")
    @TestCaseKey("ANDT-4")
    public void shouldNotLogin() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
        loginPage.login(R.TESTDATA.get("incorrect_user"), R.TESTDATA.get("incorrect_password"));
        captureScreenshot();
        assertTrue(loginPage.isErrorVisible(), "Error is not visible");
    }

    @Test(testName = "TC4")
    @TestCaseKey("ANDT-5")
    public void scrollProductPage() {
        LoginService loginService = new LoginService();
        ProductPage productPage = loginService.successfulLogin();
        productPage.assertPageOpened();
        productPage.swipeToLastProduct();
        assertTrue(productPage.isLastProductVisible(), "Last product is not visible");
    }

    @Test(testName = "TC5")
    @TestCaseKey("ANDT-6")
    public void verifyProductDetails() {
        LoginService loginService = new LoginService();
        ProductPage productBasePage = loginService.successfulLogin();
        productBasePage.assertPageOpened();
        Product randomProduct = productBasePage.getRandomProduct();
        ProductData productPicked = ProductMapper.getProduct(randomProduct);
        ProductDetailsPage productDetailsPage = randomProduct.clickOnProduct();
        ProductData productDetails = ProductMapper.getProduct(productDetailsPage);
        assertEquals(productPicked, productDetails, "Product picked does not have same data as product page");

    }

    @Test(testName = "TC6")
    @TestCaseKey("ANDT-7")
    public void verifyAddProductInCart() {
        ProductService productService = new ProductService();
        ProductDetailsPage productDetailsPage = productService.pickRandomProduct();
        productDetailsPage.addToCart();
        ProductData addedProduct = ProductMapper.getProduct(productDetailsPage);
        CartPage cartPage = productDetailsPage.getHeader().clickCartButton();
        cartPage.loadProducts();
        ProductData cartProduct = ProductMapper.getProduct(cartPage.getProducts().getFirst());
        assertEquals(addedProduct, cartProduct, "Product added to cart is not the same");
    }

    @Test(testName = "TC7")
    @TestCaseKey("ANDT-8")
    public void verifyRemoveProductFromCart() {
        ProductService productService = new ProductService();
        ProductDetailsPage productDetailsPage = productService.pickRandomProduct();
        productDetailsPage.addToCart();
        ProductData addedProduct = ProductMapper.getProduct(productDetailsPage);
        CartPage cartPage = productDetailsPage.getHeader().clickCartButton();
        cartPage.loadProducts();
        ProductData cartProduct = ProductMapper.getProduct(cartPage.getProducts().getFirst());
        assertEquals(addedProduct, cartProduct, "Product added to cart is not the same");
        cartPage.getProducts().getFirst().clickRemove();
        assertTrue(cartPage.getProducts().isEmpty(), "Product was not removed");
    }

    @Test(testName = "TC8")
    @TestCaseKey("ANDT-9")
    public void checkoutWithValidInformation() {
        ProductService productService = new ProductService();
        CartPage cartPage = productService.pickRandomProductAndVerifyCart();
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
    @TestCaseKey("ANDT-10")
    public void checkoutWithBlankInformation() {
        ProductService productService = new ProductService();
        CartPage cartPage = productService.pickRandomProductAndVerifyCart();
        CheckoutInfoPage checkoutInfoPage = cartPage.clickCheckout();
        checkoutInfoPage.clickContinue();
        assertTrue(checkoutInfoPage.isErrorVisible(), "Error message is not visible");

    }

    @Test(testName = "TC10")
    @TestCaseKey("ANDT-11")
    public void shouldLogout() {
        LoginService loginService = new LoginService();
        ProductPage productPage = loginService.successfulLogin();
        Menu menu = productPage.getHeader().clickMenuButton();
        LoginPage loginPage = menu.clickLogout();
        loginPage.assertPageOpened();
    }

    @AfterTest
    public void closeApp() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        homePage.turnOffApp();
    }

    private void captureScreenshot(){
        try{
            byte[] screenshotBytes = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            long capturedAtMillis = System.currentTimeMillis();
            Screenshot.upload(screenshotBytes, capturedAtMillis);
        } catch (Exception e) {
            throw new ScreenshotFailedException("Failed to make Screenshot");
        }
    }
}
