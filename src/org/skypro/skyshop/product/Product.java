package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    private String productName;


    public Product(String productName) {

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

    @Override
    public String getName() {
        return productName;
    }


}
