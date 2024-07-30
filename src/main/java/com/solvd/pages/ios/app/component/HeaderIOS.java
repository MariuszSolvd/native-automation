package com.solvd.pages.ios.app.component;

import com.solvd.pages.common.app.CartPage;
import com.solvd.pages.common.app.Menu;
import com.solvd.pages.common.app.component.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

@Getter
public class HeaderIOS extends Header {

    @ExtendedFindBy(iosPredicate = "name == 'test-Menu'")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Cart'")
    private ExtendedWebElement cartButton;

    public HeaderIOS(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPage clickCartButton() {
        clickIOS(cartButton);
        return initPage(getDriver(), CartPage.class);
    }

    @Override
    public Menu clickMenuButton() {
        clickIOS(menuButton);
        return initPage(getDriver(), Menu.class);
    }

    private void clickIOS(ExtendedWebElement element) {
        Point point = element.getLocation();
        Dimension size = element.getSize();
        tap(point.getX() + size.getWidth() / 2, point.getY() + size.getHeight() / 2 + 4);
    }


}
