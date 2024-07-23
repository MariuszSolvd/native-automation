package com.solvd;

import com.solvd.pages.common.HomePage;
import com.solvd.pages.common.app.LoginPage;
import com.solvd.pages.common.app.ProductBasePage;
import com.zebrunner.carina.core.AbstractTest;

import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AppTest extends AbstractTest {

    @Test
    public void shouldOpenSwagLabsApp() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
        homePage.turnOffApp();
    }

    @Test
    public void shouldLogin() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
        ProductBasePage productPage = loginPage.login(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        assertTrue(productPage.isPageOpened(), "Product page isn't open");
    }
}
