package com.solvd;

import com.solvd.pages.common.HomePage;
import com.solvd.pages.common.app.LoginPage;
import com.zebrunner.carina.core.AbstractTest;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AppTest extends AbstractTest {

    @Test
    public void shouldOpenSwagLabsApp() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        assertTrue(homePage.isAppRunning(), "App is not running");
        homePage.turnOffApp();
    }
}
