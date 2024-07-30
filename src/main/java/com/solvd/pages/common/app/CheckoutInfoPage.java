package com.solvd.pages.common.app;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutInfoPage extends RegularsPage{
    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public abstract void inputName(String name);

    public abstract void inputLastName(String lastname);

    public abstract void inputPostalCode(String code);

    public abstract void clickContinue();

    public void fillData(String name, String lastname, String code) {
        inputName(name);
        inputLastName(lastname);
        inputPostalCode(code);
        clickContinue();
    }
}
