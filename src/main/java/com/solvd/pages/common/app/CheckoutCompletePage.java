package com.solvd.pages.common.app;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutCompletePage extends RegularsPage {

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPage clickBackHome();
}
