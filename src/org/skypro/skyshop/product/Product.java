package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    private String productName;


    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }

        this.productName = productName;

    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductCost();



    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getSearchContent() {
        return "PRODUCT";
    }





}
