package com.solvd.pages.android.app.component;

import com.solvd.pages.common.app.component.Footer;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class FooterAndroid extends Footer {

    @FindBy(xpath = "//android.widget.TextView[contains(@text, '\uF099')]")
    private ExtendedWebElement twitter;

    public FooterAndroid(WebDriver driver) {
        super(driver);
    }
}
