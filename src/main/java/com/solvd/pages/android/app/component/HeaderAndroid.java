package com.solvd.pages.android.app.component;

import com.solvd.pages.common.app.component.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class HeaderAndroid extends Header {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement cartButton;

    public HeaderAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickCartButton() {
        cartButton.click();
    }

    @Override
    public void clickMenuButton() {
        menuButton.click();
    }

}
