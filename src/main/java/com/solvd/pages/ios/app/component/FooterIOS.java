package com.solvd.pages.ios.app.component;

import com.solvd.pages.common.app.component.Footer;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class FooterIOS extends Footer {

    @ExtendedFindBy(iosPredicate = "name == ''")
    private ExtendedWebElement twitter;

    public FooterIOS(WebDriver driver) {
        super(driver);
    }
}
