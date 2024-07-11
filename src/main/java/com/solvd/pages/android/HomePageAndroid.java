package com.solvd.pages.android;

import com.solvd.pages.common.app.LoginPage;
import com.solvd.pages.common.HomePage;
import com.solvd.utilis.Device;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePage.class)
public class HomePageAndroid extends HomePage {

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Search\"]")
    private ExtendedWebElement searchButton;

    public HomePageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchButton);

    }

    @Override
    public LoginPage openApp() {
        startApp(Device.ANDROID.getIdBundle());
        return initPage(getDriver(), LoginPage.class);
    }

    @Override
    public HomePage turnOffApp() {
        terminateApp(Device.ANDROID.getIdBundle());
        return initPage(getDriver(), HomePage.class);
    }


}
