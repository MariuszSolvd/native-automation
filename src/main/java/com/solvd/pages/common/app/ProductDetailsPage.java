package com.solvd.pages.common.app;

import org.openqa.selenium.WebDriver;

public abstract class ProductDetailsPage extends RegularsPage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public abstract String getNameText();

    public abstract String getPriceText();

    public abstract void addToCart();
}
