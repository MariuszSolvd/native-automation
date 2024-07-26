package com.solvd.utilis;

public final class Constants {
    public static final String HEADER_ANDROID = "//android.view.ViewGroup[@content-desc='test-Menu']/parent::android.view.ViewGroup";
    public static final String HEADER_IOS = "//XCUIElementTypeOther[@name='headerContainer']/parent::XCUIElementTypeOther";
    public static final String FOOTER_ANDROID = "//android.widget.TextView[@text='\uF099']//parent::android.view.ViewGroup";
    public static final String FOOTER_IOS = "**/XCUIElementTypeOther[`name == \"\uF099 \uF09A \uF0D5 \uF0E1 © 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy\"`][2]";
}
