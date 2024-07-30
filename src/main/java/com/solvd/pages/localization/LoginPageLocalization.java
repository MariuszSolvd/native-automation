package com.solvd.pages.localization;

import com.solvd.pages.common.app.LoginPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

//@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPage.class)
public class LoginPageLocalization extends LoginPage {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='{L10N:LoginLocalPage.username}']")
    private ExtendedWebElement loginInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='{L10N:LoginLocalPage.password}']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='{L10N:LoginLocalPage.error}']")
    private ExtendedWebElement errorMessage;

    public LoginPageLocalization(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);
    }

    @Override
    protected void inputUsername(String username) {
        loginInput.type(username);
    }

    @Override
    protected void inputPassword(String password) {
        passwordInput.type(password);
    }

    @Override
    protected void clickLoginButton() {
        loginButton.click();
    }

    @Override
    public boolean isErrorVisible() {
        return errorMessage.isVisible();
    }


}
