package org.example;

public class Cat extends Animal {


    private static int catCounter;

    public static int getFoodInBowl() {
        return foodInBowl;
    }

    private static int foodInBowl;
    private static final int PORTION_FOOD = 10;

    private boolean satiety = false;


    public Cat(String name) {
        super(name);
        catCounter += 1;
    }

    public static int getCatCounter() {
        return catCounter;
    }

    public void swim(int distance) {
        System.out.println("Коты не умеют плавать!");
    }


    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println("Кот не может пробежать больше 200 метров");
        }
    }

    public void toEat() {
        if (foodInBowl - PORTION_FOOD >= 0) {
            satiety = true;
            System.out.println(name + " сытый)))");
            foodInBowl -= PORTION_FOOD;
        } else if (foodInBowl <= 0) {
            System.out.println("Миска пустая!");
        } else {
            System.out.println(name + " остался голодным(");
        }
    }

    public static void addFood(int quantutyFood) {
        System.out.println("В миску добавлено " + quantutyFood + " еды ");
        foodInBowl = foodInBowl + quantutyFood;
        System.out.println("Обьем еды в миске " + foodInBowl);
    }
}

