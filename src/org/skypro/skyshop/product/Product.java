package org.skypro.skyshop.product;

public class Product {

    private String productName;
    private int productCost;

    public Product(String productName, int productCost) {
        if (productCost <= 0) {
            throw new IllegalArgumentException("Стоимость должна быть больше 0");
        }
        this.productName = productName;
        this.productCost = productCost;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductCost() {
        return productCost;
    }


}
