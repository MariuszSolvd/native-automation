package com.solvd.pages.common.app;

import com.solvd.pages.common.app.component.Footer;
import com.solvd.pages.common.app.component.Header;
import org.openqa.selenium.WebDriver;

public abstract class RegularsBasePage extends AppBasePage {

    public RegularsBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();

    public abstract Footer getFooter();

}
