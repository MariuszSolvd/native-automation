package com.solvd.pages.android.app;

import com.solvd.pages.android.app.component.FooterAndroid;
import com.solvd.pages.android.app.component.HeaderAndroid;
import com.solvd.pages.common.app.CheckoutCompletePage;
import com.solvd.pages.common.app.ProductPage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutCompletePage.class)
public class CheckoutCompletePageAndroid extends CheckoutCompletePage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-BACK HOME']")
    private ExtendedWebElement backHomeButton;

    @FindBy(xpath = Constants.HEADER_ANDROID)
    private HeaderAndroid header;

    @FindBy(xpath = Constants.FOOTER_ANDROID)
    private FooterAndroid footer;

    public CheckoutCompletePageAndroid(WebDriver driver) {
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
