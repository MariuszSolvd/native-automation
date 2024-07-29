
package com.solvd.pages.android.app.component;

import com.solvd.pages.common.app.component.ProductCart;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCartAndroid extends ProductCart {

    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
    private ExtendedWebElement nameProduct;

    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc='test-Price']/android.widget.TextView")
    private ExtendedWebElement priceProduct;

    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement buttonRemove;

    public ProductCartAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public String getProductName() {
        return nameProduct.getText();
    }

    @Override
    public String getProductPrice() {
        return priceProduct.getText();
    }

    @Override
    public void clickRemove() {
        buttonRemove.click();
    }


}
