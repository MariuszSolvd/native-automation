package com.solvd.pages.ios.app;

import com.solvd.pages.common.app.AppBasePageWithHeader;
import com.solvd.pages.ios.app.component.HeaderIOS;
import org.openqa.selenium.WebDriver;

public class AppBasePageWithHeaderIOS extends AppBasePageWithHeader {

    private HeaderIOS header;

    public AppBasePageWithHeaderIOS(WebDriver driver) {
        super(driver);
    }

}
