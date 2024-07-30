package com.solvd;

import com.solvd.pages.common.HomePage;
import com.solvd.pages.common.app.LoginPage;
import com.solvd.pages.common.app.ProductPage;
import com.solvd.utilis.AdbUtils;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LocalizationTest extends AbstractTest {

    @BeforeMethod
    public void setUp() {
        AdbUtils.setSystemLanguage(R.CONFIG.get("locale"));
        L10N.setLocale(R.CONFIG.get("locale"));
        L10N.load();
    }

    @Test(testName = "TCL1")
    public void validLogin() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
        loginPage.login(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        ProductPage productPage = initPage(getDriver(), ProductPage.class);
        productPage.assertPageOpened();

    }

    @Test(testName = "TCL2")
    public void invalidLogin() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
        loginPage.login(R.TESTDATA.get("incorrect_user"), R.TESTDATA.get("incorrect_password"));
        assertTrue(loginPage.isErrorVisible(), "Error is not visible");
    }
}
