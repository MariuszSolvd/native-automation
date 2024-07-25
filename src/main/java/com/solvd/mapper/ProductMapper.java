package com.solvd.mapper;

import com.solvd.model.ProductData;
import com.solvd.pages.common.app.ProductDetailsPage;
import com.solvd.pages.common.app.component.Product;

public class ProductMapper {

    public static ProductData getProduct(ProductDetailsPage productDetailsPage) {
        return new ProductData(productDetailsPage.getNameText(), productDetailsPage.getPriceText());
    }

    public static ProductData getProduct(Product product) {
        return new ProductData(product.getNameText(), product.getPriceText());
    }
}