package com.solvd.service;

import com.solvd.exception.ProductMismatchException;
import com.solvd.mapper.ProductMapper;
import com.solvd.model.ProductData;
import com.solvd.pages.common.app.ProductDetailsPage;
import com.solvd.pages.common.app.ProductPage;
import com.solvd.pages.common.app.component.Product;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class ProductService implements ICustomTypePageFactory {

    public ProductDetailsPage pickRandomProduct() {
        LoginService loginService = new LoginService();
        ProductPage productPage = loginService.successfulLogin();
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

    private boolean isProductCorrect(ProductData productPicked, ProductData productDetails) {
        return productPicked.equals(productDetails);
    }
}
