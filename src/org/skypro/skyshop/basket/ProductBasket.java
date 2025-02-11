package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private LinkedList<Product> products;
    private int count;

    public ProductBasket() {
        products = new LinkedList<>();
        this.count = 0;
    }

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
            count++;
        }
    }

    public List<Product> removedProductsByName(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if(product != null && product.getProductName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
                count--;
            }
        }
        return removedProducts;
    }


    public int totalBasketPrice() {
        int total = 0;

        for (Product product : products) {
            if(product != null) {
                total += product.getProductCost();
            }
        }
        return total;
    }

    public int countSpecialProducts() {
        int countSpecial = 0;

        for (Product product : products) {
            if (product != null && product.isSpecial()) {
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
            for (Product product : products) {
                if(product != null) {
                    System.out.println(product.toString());;
                }
            }
            System.out.println("Итого: " + totalBasketPrice());
            System.out.println("Специальных товаров: " + countSpecialProducts());
        }
    }


    public boolean existsProduct(String productName) {
        for (Product product : products ) {
            if (product != null && product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
        count = 0;
    }
}
