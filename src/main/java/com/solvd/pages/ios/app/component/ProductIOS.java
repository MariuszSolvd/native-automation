package com.solvd.pages.ios.app.component;

import com.solvd.pages.common.app.component.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


public class ProductIOS extends Product {

    @ExtendedFindBy(iosPredicate = "name == 'test-Item title'")
    private ExtendedWebElement name;

    @ExtendedFindBy(iosPredicate = "name == 'test-Price'")
    private ExtendedWebElement price;

    @ExtendedFindBy(iosPredicate = "name == 'test-ADD TO CART'")
    private ExtendedWebElement addToCart;

    public ProductIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getNameText() {
        return name.getText();
    }

    @Override
    public String getPriceText() {
        return price.getText();
    }

    @Override
    public void clickAddCart() {
        addToCart.click();
    }
}
