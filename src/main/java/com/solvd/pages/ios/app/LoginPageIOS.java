package com.solvd.pages.ios.app;

import com.solvd.pages.common.app.LoginPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPage.class)
public class LoginPageIOS extends LoginPage {

    @ExtendedFindBy(iosPredicate = "name == \"test-Username\"")
    private ExtendedWebElement loginInput;

    @ExtendedFindBy(iosPredicate = "name == \"test-Password\"")
    private ExtendedWebElement passwordInput;

    @ExtendedFindBy(iosPredicate = "name == \"test-LOGIN\"")
    private ExtendedWebElement loginButton;

    @ExtendedFindBy(iosPredicate = "name == \"test-Error message\"")
    private ExtendedWebElement errorMessage;

    public LoginPageIOS(WebDriver driver) {
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
