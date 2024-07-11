package com.solvd.pages.common.app;

import org.openqa.selenium.WebDriver;

public abstract class LoginPage extends AppBasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    protected abstract void inputUsername(String username);

    protected abstract void inputPassword(String password);

    protected abstract void clickLoginButton();

    public abstract boolean isErrorVisible();

    public void login(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }


}
