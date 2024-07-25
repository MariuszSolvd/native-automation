package com.solvd.pages.common.app.component;

import com.solvd.pages.common.app.ProductDetailsPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


public abstract class Product extends AbstractUIObject implements IMobileUtils {
    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ExtendedWebElement getProductName();

    public abstract ExtendedWebElement getProductPrice();

    public abstract void clickAddCart();

    public String getNameText() {
        swipeIfNotVisible(getProductName());
        return getProductName().getText();
    }

    public String getPriceText() {
        swipeIfNotVisible(getProductPrice());
        return getProductPrice().getText();
    }

    public ProductDetailsPage clickOnProduct() {
        click();
        return initPage(getDriver(), ProductDetailsPage.class);
    }

    private void swipeIfNotVisible(ExtendedWebElement element) {
        if (!element.isVisible(0)) {
            swipe(element);
        }
    }
}
