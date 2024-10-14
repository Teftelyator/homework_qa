package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordArray {
    List<String> fruits = Arrays.asList("Apple", "Avocado", "Banana", "Kiwi", "Apple", "Mango", "Banana", "Banana", "Orange", "Mango");

    public void originalList() {
        System.out.println("Исходный список :");
        fruits.forEach(System.out::println);
    }

    public void uniqueList() {
        Map<String, Integer> uniqueFruits = new HashMap<>();
        for (String s : fruits) {
            uniqueFruits.put(s, uniqueFruits.getOrDefault(s, 0) + 1);
        }
        System.out.println("Список уникальных значений с количеством повторений :");
        uniqueFruits.entrySet().forEach(System.out::println);
    }
}
