package com.solvd.pages.common.app;

import com.solvd.pages.common.app.component.ProductCart;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CheckoutOverviewPage extends RegularsPage{
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public abstract List<? extends ProductCart> getProducts();

    public abstract CheckoutCompletePage clickFinishButton();
}
