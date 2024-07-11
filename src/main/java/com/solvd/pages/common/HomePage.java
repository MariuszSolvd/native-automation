package com.solvd.pages.common;

import com.solvd.pages.common.app.LoginPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePage extends AbstractPage implements IMobileUtils {

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public abstract LoginPage openApp();

    public abstract HomePage turnOffApp();

}
