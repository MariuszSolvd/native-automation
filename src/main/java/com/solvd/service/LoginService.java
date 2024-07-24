package com.solvd.service;

import com.solvd.pages.common.HomePage;
import com.solvd.pages.common.app.LoginPage;
import com.solvd.pages.common.app.ProductBasePage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class LoginService implements ICustomTypePageFactory {

    public ProductBasePage successfulLogin() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        loginPage.login(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        return initPage(getDriver(), ProductBasePage.class);
    }
}
