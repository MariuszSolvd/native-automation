package com.solvd.pages.android.app;

import com.solvd.pages.android.app.component.ProductCartAndroid;
import com.solvd.pages.common.app.CartPage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.pages.common.app.component.ProductCart;
import com.solvd.pages.ios.app.component.FooterIOS;
import com.solvd.pages.ios.app.component.HeaderIOS;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPage.class)
public class CartPageAndroid extends CartPage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductCartAndroid> products;

    @FindBy(xpath = Constants.HEADER_ANDROID)
    private HeaderIOS header;

    @FindBy(xpath = Constants.FOOTER_ANDROID)
    private FooterIOS footer;


    public CartPageAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<? extends ProductCart> getProducts() {
        return products;
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