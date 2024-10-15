package org.example.taskAnimal;

import static org.example.taskAnimal.Bowl.getFoodInBowl;
import static org.example.taskAnimal.Bowl.setFoodInBowl;

public class Cat extends Animal {
    private static int catCounter;
    static final int PORTION_FOOD = 10;
    private boolean satiety = false;

    public Cat(String name) {
        super(name);
        catCounter += 1;
    }

    public void toEat() {
        if (getFoodInBowl() - PORTION_FOOD >= 0) {
            this.satiety = true;
            setFoodInBowl(getFoodInBowl() - PORTION_FOOD);
        } else if (getFoodInBowl() <= 0) {
            this.satiety = false;
            System.out.println("Миска пустая!");
        }
    }

    public static String getCatCounter() {
        return "Всего котов :" + catCounter;
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать!");
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м");
        } else {
            System.out.println("Кот не может пробежать больше 200 метров");
        }
    }

    public void infoSatietyCat() {
        if (satiety) {
            System.out.println(name + " сытый)))");
        } else {
            System.out.println(name + " остался голодным(");
        }
    }
}

