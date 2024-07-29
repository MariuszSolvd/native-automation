package com.solvd.pages.common.app.component;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductCart extends AbstractUIObject {
    public ProductCart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getProductName();

    public abstract String getProductPrice();
}
