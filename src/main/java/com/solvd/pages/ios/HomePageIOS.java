package com.solvd.pages.ios;

import com.solvd.pages.common.app.LoginPage;
import com.solvd.pages.common.HomePage;
import com.solvd.utilis.Device;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePage.class)
public class HomePageIOS extends HomePage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"spotlight-pill\" AND label == \"Search\"`]")
    private ExtendedWebElement searchButton;

    public HomePageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchButton);
    }

    @Override
    public LoginPage openApp() {
        startApp(Device.IOS.getIdBundle());
        return initPage(getDriver(), LoginPage.class);
    }

    @Override
    public HomePage turnOffApp() {
        terminateApp(Device.IOS.getIdBundle());
        return initPage(getDriver(), HomePage.class);
    }
}
