package com.solvd.pages.common.app;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class Menu extends AbstractPage {

    public Menu(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPage clickLogout();
}
