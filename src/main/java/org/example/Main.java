package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dog bobik = new Dog("Бобик");
        bobik.swim(4);
        bobik.run(501);

        Cat barsik = new Cat("Барсик");
        barsik.run(121);
        barsik.swim(20);
        barsik.toEat();

        Cat.addFood(23);
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Кокос"));
        cats.add(new Cat("Гав"));
        cats.add(new Cat("Tом"));
        cats.add(new Cat("Леопольд"));
        for (Cat cat : cats) {
            cat.toEat();
        }

        System.out.println(Dog.getDogCounter());
        System.out.println(Cat.getCatCounter());
        System.out.println(Animal.getAnimalCounter());
    }
}