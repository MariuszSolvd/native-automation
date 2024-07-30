package com.solvd.pages.ios.app;

import com.solvd.pages.common.app.CartPage;
import com.solvd.pages.common.app.CheckoutInfoPage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.pages.common.app.component.ProductCart;
import com.solvd.pages.ios.app.component.FooterIOS;
import com.solvd.pages.ios.app.component.HeaderIOS;
import com.solvd.pages.ios.app.component.ProductCartIOS;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPage.class)
public class CartPageIOS extends CartPage {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item']")
    private List<ProductCartIOS> products;

    @ExtendedFindBy(iosPredicate = "name == 'test-CHECKOUT'")
    private ExtendedWebElement checkoutButton;

    @ExtendedFindBy(iosClassChain = Constants.HEADER_IOS)
    private HeaderIOS header;

    @ExtendedFindBy(iosClassChain = Constants.FOOTER_IOS)
    private FooterIOS footer;


    public CartPageIOS(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<? extends ProductCart> getProducts() {
        return products;
    }

    @Override
    public CheckoutInfoPage clickCheckout() {
        swipe(checkoutButton);
        checkoutButton.click();
        return initPage(getDriver(), CheckoutInfoPage.class);
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