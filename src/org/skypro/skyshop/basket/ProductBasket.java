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
        return productsMap.values().stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getProductCost)
                .sum();
    }

    public int countSpecialProducts() {
        return (int) productsMap.values().stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Содержимое корзины:");
            productsMap.values().stream()
                    .flatMap(List::stream)
                    .filter(Objects::nonNull)
                    .forEach(product -> System.out.println(product.toString()));
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
