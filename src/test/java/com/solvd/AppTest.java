package com.solvd;

import com.solvd.mapper.ProductMapper;
import com.solvd.model.ProductData;
import com.solvd.pages.common.HomePage;
import com.solvd.pages.common.app.CartPage;
import com.solvd.pages.common.app.LoginPage;
import com.solvd.pages.common.app.ProductDetailsPage;
import com.solvd.pages.common.app.ProductPage;
import com.solvd.pages.common.app.component.Product;
import com.solvd.service.LoginService;
import com.solvd.service.ProductService;
import com.zebrunner.carina.core.AbstractTest;

import com.zebrunner.carina.utils.R;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AppTest extends AbstractTest {

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
        LoginService loginService = new LoginService();
        ProductPage productPage = loginService.successfulLogin();
        productPage.assertPageOpened();
        productPage.swipeToLastProduct();
        assertTrue(productPage.isLastProductVisible(), "Last product is not visible");
    }

    @Test(testName = "TC5")
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
    public void verifyAddProductInCart() {
        ProductService productService = new ProductService();
        ProductDetailsPage productDetailsPage = productService.pickRandomProduct();
        productDetailsPage.addToCart();
        ProductData addedProduct = ProductMapper.getProduct(productDetailsPage);
        CartPage cartPage = productDetailsPage.getHeader().clickCartButton();
        ProductData cartProduct = ProductMapper.getProduct(cartPage.getProducts().getFirst());
        assertEquals(addedProduct, cartProduct, "Product add to cart is not the same");
    }

    @AfterTest
    public void closeApp() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        homePage.turnOffApp();
    }
}
