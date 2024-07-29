package com.solvd.pages.common.app.component;

import com.solvd.pages.common.app.CartPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class Header extends AbstractUIObject implements IMobileUtils {
    public Header(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getMenuButton();

    public abstract ExtendedWebElement getCartButton();

    public abstract CartPage clickCartButton();

    public abstract void clickMenuButton();
}
