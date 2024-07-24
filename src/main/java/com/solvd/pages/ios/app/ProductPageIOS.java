package com.solvd.pages.ios.app;

import com.solvd.pages.common.app.ProductBasePage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.pages.ios.app.component.FooterIOS;
import com.solvd.pages.ios.app.component.HeaderIOS;
import com.solvd.pages.ios.app.component.ProductIOS;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductBasePage.class)
public class ProductPageIOS extends ProductBasePage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    private List<ProductIOS> products;

    @ExtendedFindBy(iosPredicate = "name == 'test-Modal Selector Button'")
    private ExtendedWebElement sortButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Cart drop zone'")
    private HeaderIOS header;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == " +
            "\"\uF099 \uF09A \uF0D5 \uF0E1 © 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy\"`][2]")
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


}
