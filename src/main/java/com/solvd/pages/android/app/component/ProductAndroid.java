package com.solvd.pages.android.app.component;

import com.solvd.pages.common.app.component.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
@EqualsAndHashCode(callSuper = false)
public class ProductAndroid extends Product {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private ExtendedWebElement addToCart;

    public ProductAndroid(WebDriver driver, SearchContext searchContext) {
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
