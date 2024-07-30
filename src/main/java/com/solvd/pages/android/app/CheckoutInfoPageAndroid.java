package com.solvd.pages.android.app;

import com.solvd.pages.android.app.component.FooterAndroid;
import com.solvd.pages.android.app.component.HeaderAndroid;
import com.solvd.pages.common.app.CheckoutInfoPage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutInfoPage.class)
public class CheckoutInfoPageAndroid extends CheckoutInfoPage {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
    private ExtendedWebElement firstnameInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
    private ExtendedWebElement lastnameInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
    private ExtendedWebElement postalCodeInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CONTINUE']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = Constants.HEADER_ANDROID)
    private HeaderAndroid header;

    @FindBy(xpath = Constants.FOOTER_ANDROID)
    private FooterAndroid footer;

    public CheckoutInfoPageAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public void inputName(String name) {
        firstnameInput.type(name);
    }

    @Override
    public void inputLastName(String lastname) {
        lastnameInput.type(lastname);
    }

    @Override
    public void inputPostalCode(String code) {
        postalCodeInput.type(code);
    }

    @Override
    public void clickContinue() {
        continueButton.click();
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
