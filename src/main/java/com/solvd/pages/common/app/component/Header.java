package com.solvd.pages.common.app.component;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class Header extends AbstractUIObject {
    public Header(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getMenuButton();

    public abstract ExtendedWebElement getCartButton();
}
