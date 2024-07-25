package com.solvd.pages.ios.app;

import com.solvd.pages.common.app.ProductDetailsPage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.pages.ios.app.component.FooterIOS;
import com.solvd.pages.ios.app.component.HeaderIOS;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductDetailsPage.class)
public class ProductDetailsPageIOS extends ProductDetailsPage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Description'`]/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement name;

    @ExtendedFindBy(iosPredicate = "name == 'test-Price'")
    private ExtendedWebElement price;

    @ExtendedFindBy(iosPredicate = Constants.HEADER_IOS)
    private HeaderIOS header;

    @ExtendedFindBy(iosClassChain = Constants.FOOTER_IOS)
    private FooterIOS footer;

    public ProductDetailsPageIOS(WebDriver driver) {
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
    public Header getHeader() {
        return header;
    }

    @Override
    public Footer getFooter() {
        return footer;
    }
}
