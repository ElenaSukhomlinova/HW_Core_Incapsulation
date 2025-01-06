package org.skypro.skyshop;


import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;



public class App {
    public static void main(String[] args) {

        Product apple = new Product("Яблоко", 115);
        Product pear = new Product("Груша", 130);
        Product melon = new Product("Дыня", 95);
        Product watermelon = new Product("Арбуз", 70);
        Product plum = new Product("Слива", 145);
        Product grape = new Product("Виноград", 125);

        ProductBasket basket = new ProductBasket();

        // Добавление продукта в корзину
        basket.addProduct(apple);
        basket.addProduct(melon);
        basket.addProduct(plum);
        basket.addProduct(grape);
        basket.addProduct(watermelon);

        // Добавление продукта в заполненную корзину
        //basket.addProduct(pear);

        // Печать содержимого корзины
        basket.printBasket();

        // Получение стоимости корзины
        System.out.println("Общая стоимость: " + basket.totalBasketPrice());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли в корзине арбуз " + basket.existsProduct("Арбуз"));

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли в корзине груша " + basket.existsProduct("Груша"));

        // Очистка корзины
        basket.clearBasket();

        // Печать содержимого пустой корзины
        basket.printBasket();

        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость: " + basket.totalBasketPrice());

        // Поиск товара по имени в пустой корзине
        //System.out.println("Есть ли в корзине арбуз " + basket.existsProduct("Арбуз"));
    }
}