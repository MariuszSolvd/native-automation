package com.solvd.utilis;

import lombok.Getter;

@Getter
public enum Device {

    IOS("com.saucelabs.SwagLabsMobileApp"),
    ANDROID("com.swaglabsmobileapp");

    private final String idBundle;

    Device(String idBundle) {
        this.idBundle = idBundle;
    }
}
