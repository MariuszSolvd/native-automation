package com.solvd.pages.ios.app.component;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class HeaderIOS extends AbstractUIObject {

    @ExtendedFindBy(iosPredicate = "name == 'test-Menu'")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Cart'")
    private ExtendedWebElement cartButton;

    public HeaderIOS(WebDriver driver) {
        super(driver);
    }
}
