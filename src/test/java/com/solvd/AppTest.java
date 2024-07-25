package com.solvd;

import com.solvd.pages.common.HomePage;
import com.solvd.pages.common.app.LoginPage;
import com.solvd.pages.common.app.ProductBasePage;
import com.solvd.service.LoginService;
import com.zebrunner.carina.core.AbstractTest;

import com.zebrunner.carina.utils.R;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AppTest extends AbstractTest {

    @Test
    public void shouldOpenSwagLabsApp() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
    }

    @Test
    public void shouldLogin() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
        loginPage.login(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        ProductBasePage productPage = initPage(getDriver(), ProductBasePage.class);
        productPage.assertPageOpened();
    }

    @Test
    public void shouldNotLogin() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
        loginPage.login(R.TESTDATA.get("incorrect_user"), R.TESTDATA.get("incorrect_password"));
        assertTrue(loginPage.isErrorVisible(), "Error is not visible");

    }

    @Test
    public void scrollProductPage() {
        LoginService loginService = new LoginService();
        ProductBasePage productPage = loginService.successfulLogin();
        productPage.assertPageOpened();
        productPage.swipeToLastProduct();
        assertTrue(productPage.isLastProductVisible(), "Last product is not visible");
    }

    @AfterTest
    public void closeApp() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        homePage.turnOffApp();
    }
}
