package com.solvd.pages.ios.app.component;

import com.solvd.pages.common.app.component.ProductCart;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCartIOS extends ProductCart {

    @FindBy(xpath = ".//XCUIElementTypeOther[@name='test-Description']/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement nameProduct;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Price'`]/XCUIElementTypeStaticText")
    private ExtendedWebElement priceProduct;

    public ProductCartIOS(WebDriver driver, SearchContext searchContext) {
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


}
