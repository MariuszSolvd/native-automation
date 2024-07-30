package com.solvd.pages.ios.app;

import com.solvd.pages.common.app.LoginPage;
import com.solvd.pages.common.app.Menu;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = Menu.class)
public class MenuIOS extends Menu {

    @ExtendedFindBy(iosPredicate = "name == 'test-LOGOUT'")
    private ExtendedWebElement logoutButton;

    public MenuIOS(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage clickLogout() {
        logoutButton.click();
        return initPage(getDriver(), LoginPage.class);
    }
}
