package com.solvd.pages.android.app;

import com.solvd.pages.android.app.component.FooterAndroid;
import com.solvd.pages.android.app.component.HeaderAndroid;
import com.solvd.pages.android.app.component.ProductAndroid;
import com.solvd.pages.common.app.ProductPage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.pages.common.app.component.Product;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPage.class)
public class ProductPageAndroid extends ProductPage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductAndroid> products;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']")
    private ExtendedWebElement sortButton;

    @FindBy(xpath = Constants.HEADER_ANDROID)
    private HeaderAndroid header;

    @FindBy(xpath = Constants.FOOTER_ANDROID)
    private FooterAndroid footer;

    public ProductPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(sortButton);
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public Footer getFooter() {
        return footer;
    }

    @Override
    public void swipeToLastProduct() {
        swipe(footer.getTwitter());
    }

    @Override
    public boolean isLastProductVisible() {
        return products.getLast().getNameText().equals("Test.allTheThings() T-Shirt (Red)")
                && products.getLast().isVisible();
    }

    @Override
    public List<? extends Product> getProducts() {
        return products;
    }

}
