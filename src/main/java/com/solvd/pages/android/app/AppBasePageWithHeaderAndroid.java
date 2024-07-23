package com.solvd.pages.android.app;

import com.solvd.pages.android.app.component.HeaderAndroid;
import com.solvd.pages.common.app.AppBasePageWithHeader;
import org.openqa.selenium.WebDriver;

public class AppBasePageWithHeaderAndroid extends AppBasePageWithHeader {

    private HeaderAndroid header;

    public AppBasePageWithHeaderAndroid(WebDriver driver) {
        super(driver);
    }

}
