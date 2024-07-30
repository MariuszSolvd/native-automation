package com.solvd.pages.ios.app;

import com.solvd.pages.common.app.CheckoutInfoPage;
import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import com.solvd.pages.ios.app.component.FooterIOS;
import com.solvd.pages.ios.app.component.HeaderIOS;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutInfoPage.class)
public class CheckoutInfoPageIOS extends CheckoutInfoPage {

    @ExtendedFindBy(iosPredicate = "name == 'test-First Name'")
    private ExtendedWebElement firstnameInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-Last Name'")
    private ExtendedWebElement lastnameInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-Zip/Postal Code'")
    private ExtendedWebElement postalCodeInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-CONTINUE'")
    private ExtendedWebElement continueButton;

    @ExtendedFindBy(iosClassChain = Constants.HEADER_IOS)
    private HeaderIOS header;

    @ExtendedFindBy(iosClassChain = Constants.FOOTER_IOS)
    private FooterIOS footer;

    public CheckoutInfoPageIOS(WebDriver driver) {
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
