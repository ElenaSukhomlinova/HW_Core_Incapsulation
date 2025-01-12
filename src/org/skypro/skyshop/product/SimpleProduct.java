package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    @Override
    public int getProductCost() {
        return productPrice;
    }

    @Override
    public String toString() {
        return String.format("Имя продукта: %s, Стоимость: %d", getProductName(), getProductCost());
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

}
