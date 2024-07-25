package com.solvd.pages.common.app;

import com.solvd.pages.common.app.component.Product;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

public abstract class ProductPage extends RegularsPage {

    public ProductPage(WebDriver driver) {
        super(driver);

    }

    public abstract void swipeToLastProduct();

    public abstract boolean isLastProductVisible();

    public abstract List<? extends Product> getProducts();

    public Product getRandomProduct() {
        Random random = new Random();
        int randomIndex = random.nextInt(getProducts().size());
        return getProducts().get(randomIndex);
    }

}
