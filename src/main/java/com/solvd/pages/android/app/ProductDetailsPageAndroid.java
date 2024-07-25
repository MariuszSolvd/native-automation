package com.solvd.pages.android.app;

import com.solvd.pages.android.app.component.FooterAndroid;
import com.solvd.pages.android.app.component.HeaderAndroid;
import com.solvd.pages.common.app.ProductDetailsPage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsPage.class)
public class ProductDetailsPageAndroid extends ProductDetailsPage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
    private ExtendedWebElement name;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private ExtendedWebElement price;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addToCarButton;

    @FindBy(xpath = Constants.HEADER_ANDROID)
    private HeaderAndroid header;

    @FindBy(xpath = Constants.FOOTER_ANDROID)
    private FooterAndroid footer;

    public ProductDetailsPageAndroid(WebDriver driver) {
        super(driver);
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
    public void addToCart() {
        addToCarButton.click();
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public Footer getFooter() {
        return footer;
    }
}
