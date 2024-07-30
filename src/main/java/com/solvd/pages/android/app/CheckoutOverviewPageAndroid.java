package com.solvd.pages.android.app;

import com.solvd.pages.android.app.component.FooterAndroid;
import com.solvd.pages.android.app.component.HeaderAndroid;
import com.solvd.pages.android.app.component.ProductCartAndroid;
import com.solvd.pages.common.app.CheckoutCompletePage;
import com.solvd.pages.common.app.CheckoutOverviewPage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.pages.common.app.component.ProductCart;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutOverviewPage.class)
public class CheckoutOverviewPageAndroid extends CheckoutOverviewPage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductCartAndroid> products;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
    private ExtendedWebElement finishButton;

    @FindBy(xpath = Constants.HEADER_ANDROID)
    private HeaderAndroid header;

    @FindBy(xpath = Constants.FOOTER_ANDROID)
    private FooterAndroid footer;

    public CheckoutOverviewPageAndroid(WebDriver driver) {
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
