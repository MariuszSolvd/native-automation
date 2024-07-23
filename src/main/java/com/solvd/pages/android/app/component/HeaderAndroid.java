package com.solvd.pages.android.app.component;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderAndroid extends AbstractUIObject {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement cartButton;

    public HeaderAndroid(WebDriver driver) {
        super(driver);
    }
}
