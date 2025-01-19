package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int percentDiscount;

    public DiscountedProduct(String productName, int basePrice, int percentDiscount) {
        super(productName);
        this.basePrice = basePrice;
        this.percentDiscount = percentDiscount;
    }

    public int getPercentDiscount() {
        return percentDiscount;
    }

    @Override
    public int getProductCost() {
        return basePrice - (basePrice * percentDiscount / 100);
    }

    @Override
    public String toString() {
        return String.format("Имя продукта со скидкой: %s, Стоимость: %d, (Скидка: %d%%)", getProductName(), getProductCost(), getPercentDiscount());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


}
