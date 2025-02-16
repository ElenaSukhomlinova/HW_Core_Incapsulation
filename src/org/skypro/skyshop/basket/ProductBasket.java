package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productsMap;
    private int count;


    public ProductBasket() {
        productsMap = new LinkedHashMap<>();
        this.count = 0;
    }

    public void addProduct(Product product) {
        if (product != null) {
            productsMap.computeIfAbsent(product.getProductName(), k-> new LinkedList<>()).add(product);
            count++;
        }
    }

    public List<Product> removedProductsByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);
        if (removedProducts != null) {
            count -= removedProducts.size();
            return removedProducts;
        }
        return Collections.emptyList();
    }

    public int totalBasketPrice() {
        int total = 0;

        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                if(product != null) {
                    total += product.getProductCost();
                }
            }
        }
        return total;
    }

    public int countSpecialProducts() {
        int countSpecial = 0;

        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                if (product != null && product.isSpecial()) {
                    countSpecial++;
                }
            }
        }
        return countSpecial;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Содержимое корзины:");
            for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
                for (Product product : entry.getValue()) {
                    if(product != null) {
                        System.out.println(product.toString());
                    }
                }
            }
            System.out.println("Итого: " + totalBasketPrice());
            System.out.println("Специальных товаров: " + countSpecialProducts());
        }
    }


    public boolean existsProduct (String productName) {
        return productsMap.containsKey(productName);
    }

    public void clearBasket() {
        productsMap.clear();
        count = 0;
    }
}
