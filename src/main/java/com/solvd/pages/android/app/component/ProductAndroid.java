package com.solvd.pages.android.app.component;

import com.solvd.pages.common.app.component.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@EqualsAndHashCode(callSuper = false)
public class ProductAndroid extends Product {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    private ExtendedWebElement name;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private ExtendedWebElement price;

    @FindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private ExtendedWebElement addToCart;

    public ProductAndroid(WebDriver driver, SearchContext searchContext) {
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
