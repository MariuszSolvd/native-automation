package com.solvd.pages.ios.app;

import com.solvd.pages.common.app.ProductBasePage;
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

    public ProductPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(sortButton);
    }
}
