package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products;
    private int count;

    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;
    }

    public void addProduct(Product product) {
        if (count <= products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int totalBasketPrice() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            total += products[i].getProductCost();
        }
        return total;
    }

    public int countSpecialProducts() {
        int countSpecial = 0;

        for (int i = 0; i < products.length; i++) {
            if (products[i].isSpecial()) {
                countSpecial++;
            }
        }
        return countSpecial;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Содержимое корзины:");
            for (int i = 0; i < count; i++) {
                if(products[i] != null) {
                    System.out.println(products[i].toString());;
                }
            }
            System.out.println("Итого: " + totalBasketPrice());
            System.out.println("Специальных товаров: " + countSpecialProducts());
        }
    }


    public boolean existsProduct(String productName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        count = 0;
    }
}
