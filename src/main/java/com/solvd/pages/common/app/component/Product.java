package com.solvd.pages.common.app.component;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


public abstract class Product extends AbstractUIObject {
    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getNameText();

    public abstract String getPriceText();

    public abstract void clickAddCart();
}
