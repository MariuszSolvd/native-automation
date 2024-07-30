package com.solvd.pages.ios.app;

import com.solvd.pages.common.app.ProductPage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.pages.common.app.component.Product;
import com.solvd.pages.ios.app.component.FooterIOS;
import com.solvd.pages.ios.app.component.HeaderIOS;
import com.solvd.pages.ios.app.component.ProductIOS;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPage.class)
public class ProductPageIOS extends ProductPage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    private List<ProductIOS> products;

    @ExtendedFindBy(iosPredicate = "name == 'test-Modal Selector Button'")
    private ExtendedWebElement sortButton;

    @ExtendedFindBy(iosClassChain = Constants.HEADER_IOS)
    private HeaderIOS header;

    @ExtendedFindBy(iosClassChain = Constants.FOOTER_IOS)
    private FooterIOS footer;

    public ProductPageIOS(WebDriver driver) {
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
        swipe(products.getLast());
    }

    @Override
    public boolean isLastProductVisible() {
        return products.getLast().isVisible();
    }

    @Override
    public List<? extends Product> getProducts() {
        return products;
    }

}
