package com.solvd;

import com.solvd.exception.ProductMismatchException;
import com.solvd.mapper.ProductMapper;
import com.solvd.model.ProductData;
import com.solvd.pages.common.HomePage;
import com.solvd.pages.common.app.CartPage;
import com.solvd.pages.common.app.LoginPage;
import com.solvd.pages.common.app.ProductDetailsPage;
import com.solvd.pages.common.app.ProductPage;
import com.solvd.pages.common.app.component.Product;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;

public abstract class TestBase extends AbstractTest {

    protected ProductPage successfulLogin() {
        HomePage homePage = initPage(getDriver(), HomePage.class);
        LoginPage loginPage = homePage.openApp();
        loginPage.login(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        return initPage(getDriver(), ProductPage.class);
    }

    protected ProductDetailsPage pickRandomProduct() {
        ProductPage productPage = successfulLogin();
        productPage.assertPageOpened();
        Product randomProduct = productPage.getRandomProduct();
        ProductData productPicked = ProductMapper.getProduct(randomProduct);
        ProductDetailsPage productDetailsPage = randomProduct.clickOnProduct();
        ProductData productDetails = ProductMapper.getProduct(productDetailsPage);
        if (!isProductCorrect(productPicked, productDetails)) {
            throw new ProductMismatchException(
                    String.format("Product picked (%s), does not match product details page(%s)",
                            productPicked, productDetails)
            );
        }
        return initPage(getDriver(), ProductDetailsPage.class);
    }

    protected CartPage pickRandomProductAndVerifyCart() {
        ProductDetailsPage productDetailsPage = pickRandomProduct();
        productDetailsPage.addToCart();
        ProductData productPicked = ProductMapper.getProduct(productDetailsPage);
        CartPage cartPage = productDetailsPage.getHeader().clickCartButton();
        ProductData cartProduct = ProductMapper.getProduct(cartPage.getProducts().getFirst());
        if (!isProductCorrect(productPicked, cartProduct)) {
            throw new ProductMismatchException(
                    String.format("Product picked (%s), does not match product in cart (%s)",
                            productPicked, cartProduct)
            );
        }
        return initPage(getDriver(), CartPage.class);
    }

    private boolean isProductCorrect(ProductData productPicked, ProductData productGet) {
        return productPicked.equals(productGet);
    }
}
