package com.solvd.pages.ios.app;

import com.solvd.pages.common.app.CheckoutCompletePage;
import com.solvd.pages.common.app.CheckoutOverviewPage;
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

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutOverviewPage.class)
public class CheckoutOverviewPageIOS extends CheckoutOverviewPage {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item']")
    private List<ProductCartIOS> products;

    @ExtendedFindBy(iosPredicate = "name == 'test-FINISH'")
    private ExtendedWebElement finishButton;

    @ExtendedFindBy(iosClassChain = Constants.HEADER_IOS)
    private HeaderIOS header;

    @ExtendedFindBy(iosClassChain = Constants.FOOTER_IOS)
    private FooterIOS footer;

    public CheckoutOverviewPageIOS(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<? extends ProductCart> getProducts() {
        return products;
    }

    @Override
    public CheckoutCompletePage clickFinishButton() {
        swipe(finishButton);
        finishButton.click();
        return initPage(getDriver(), CheckoutCompletePage.class);
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
