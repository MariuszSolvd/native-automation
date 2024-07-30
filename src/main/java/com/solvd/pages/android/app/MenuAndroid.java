package com.solvd.pages.android.app;

import com.solvd.pages.common.app.LoginPage;
import com.solvd.pages.common.app.Menu;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = Menu.class)
public class MenuAndroid extends Menu {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGOUT']")
    private ExtendedWebElement logoutButton;

    public MenuAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage clickLogout() {
        logoutButton.click();
        return initPage(getDriver(), LoginPage.class);
    }
}
