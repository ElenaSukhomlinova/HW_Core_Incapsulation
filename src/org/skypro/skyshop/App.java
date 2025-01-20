package org.skypro.skyshop;


import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.sql.SQLOutput;
import java.util.Arrays;


public class App {
    public static void main(String[] args) {

        SimpleProduct apple = new SimpleProduct("Яблоко", 115);
        SimpleProduct pear = new SimpleProduct("Груша", 130);
        SimpleProduct melon = new SimpleProduct("Дыня", 95);
        SimpleProduct watermelon = new SimpleProduct("Арбуз", 70);
        SimpleProduct plum = new SimpleProduct("Слива", 145);
        SimpleProduct grape = new SimpleProduct("Виноград", 125);

        DiscountedProduct orange = new DiscountedProduct("Апельсин", 95, 5);
        DiscountedProduct grapefruits = new DiscountedProduct("Грейпфрукт", 105, 5);

        FixPriceProduct oil = new FixPriceProduct("Масло");

        ProductBasket basket = new ProductBasket();

        // Добавление продукта в корзину
        basket.addProduct(apple);
        basket.addProduct(plum);
        basket.addProduct(grape);
        basket.addProduct(orange);
        basket.addProduct(oil);


        // Добавление продукта в заполненную корзину
        //basket.addProduct(pear);

        // Печать содержимого корзины
        basket.printBasket();

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли в корзине арбуз " + basket.existsProduct("Арбуз"));

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли в корзине апельсин " + basket.existsProduct("Апельсин"));

        // Очистка корзины
        basket.clearBasket();

        // Печать содержимого пустой корзины
        basket.printBasket();

        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость: " + basket.totalBasketPrice());

        // Поиск товара по имени в пустой корзине
        //System.out.println("Есть ли в корзине арбуз " + basket.existsProduct("Арбуз"));

        SearchEngine searchEngine = new SearchEngine(10);


        searchEngine.addItem(new Article("Дыня", "Сочная и вкусная"));
        searchEngine.addItem(new Article("Арбуз", "Спелый и красный"));
        searchEngine.addItem(new Article("Виноград", "Лучшие грозди"));

        searchEngine.addItem(new Article("Масло", "Пастеризованное, лучшего отжима"));

        String searchRequest1 = "Дын";
        System.out.println("Поиск \"" + searchRequest1 + "\": " + Arrays.toString(searchEngine.search(searchRequest1)));

        String searchRequest2 = "буз";
        System.out.println("Поиск \"" + searchRequest2 + "\": " + Arrays.toString(searchEngine.search(searchRequest2)));



    }
}