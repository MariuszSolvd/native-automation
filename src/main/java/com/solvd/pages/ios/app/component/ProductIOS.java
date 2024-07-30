package com.solvd.pages.ios.app.component;

import com.solvd.pages.common.app.component.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@Getter
@EqualsAndHashCode(callSuper = false)
public class ProductIOS extends Product {

    @ExtendedFindBy(iosPredicate = "name == 'test-Item title'")
    private ExtendedWebElement productName;

    @ExtendedFindBy(iosPredicate = "name == 'test-Price'")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(iosPredicate = "name == 'test-ADD TO CART'")
    private ExtendedWebElement addToCart;

    public ProductIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public ExtendedWebElement getProductName() {
        return productName;
    }

    @Override
    public ExtendedWebElement getProductPrice() {
        return productPrice;
    }

    @Override
    public void clickAddCart() {
        addToCart.click();
    }
}
