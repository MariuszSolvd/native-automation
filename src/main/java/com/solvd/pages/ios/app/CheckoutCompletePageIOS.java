package com.solvd.pages.ios.app;

import com.solvd.pages.common.app.CheckoutCompletePage;
import com.solvd.pages.common.app.ProductPage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.pages.ios.app.component.FooterIOS;
import com.solvd.pages.ios.app.component.HeaderIOS;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutCompletePage.class)
public class CheckoutCompletePageIOS extends CheckoutCompletePage {

    @ExtendedFindBy(iosPredicate = "name == 'test-BACK HOME'")
    private ExtendedWebElement backHomeButton;

    @ExtendedFindBy(iosClassChain = Constants.HEADER_IOS)
    private HeaderIOS header;

    @ExtendedFindBy(iosClassChain = Constants.FOOTER_IOS)
    private FooterIOS footer;

    public CheckoutCompletePageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(backHomeButton);
    }

    @Override
    public ProductPage clickBackHome() {
        backHomeButton.click();
        return initPage(getDriver(), ProductPage.class);
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
