package com.solvd.pages.common.app;

import com.solvd.pages.common.app.component.ProductCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public abstract class CartPage extends RegularsPage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public abstract List<? extends ProductCart> getProducts();

    public abstract CheckoutInfoPage clickCheckout();

    public void loadProducts() {
        waitUntil((ExpectedCondition<Boolean>) condition -> !getProducts().isEmpty(), 30);
    }
}
