package com.solvd.pages.common.app;

import org.openqa.selenium.WebDriver;

public abstract class ProductBasePage extends RegularsBasePage {

    public ProductBasePage(WebDriver driver) {
        super(driver);

    }

    public abstract void swipeToLastProduct();

    public abstract boolean isLastProductVisible();

}
