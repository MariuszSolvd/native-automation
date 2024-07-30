package com.solvd.pages.common.app;

import com.solvd.pages.common.HomePage;
import com.solvd.utilis.Device;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AppPage extends AbstractPage implements IMobileUtils {

    public AppPage(WebDriver driver) {
        super(driver);
    }

    public HomePage quitApp(Device device) {
        terminateApp(device.getIdBundle());
        return initPage(getDriver(), HomePage.class);
    }
}
