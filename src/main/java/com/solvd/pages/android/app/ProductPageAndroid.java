package com.solvd.pages.android.app;

import com.solvd.pages.android.app.component.ProductAndroid;
import com.solvd.pages.common.app.ProductBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductBasePage.class)
public class ProductPageAndroid extends ProductBasePage {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-PRODUCTS']" +
            "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductAndroid> products;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']")
    private ExtendedWebElement sortButton;


    public ProductPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(sortButton);
    }
}
