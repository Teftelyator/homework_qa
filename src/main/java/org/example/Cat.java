package org.example;

public class Cat extends Animal {
    private static int catCounter;
    private static int foodInBowl;
    private static final int PORTION_FOOD = 10;
    private boolean satiety = false;

    public Cat(String name) {
        super(name);
        catCounter += 1;
    }

    public static String getFoodInBowl() {
        return "Еды в миске :" + foodInBowl;
    }

    public static String getCatCounter() {
        return "Всего котов :" + catCounter;
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
            this.satiety = true;
            foodInBowl -= PORTION_FOOD;
        } else if (foodInBowl <= 0) {
            this.satiety = false;
            System.out.println("Миска пустая!");
        }
    }

    public void infoSatietyCat() {
        if (satiety) {
            System.out.println(name + " сытый)))");
        } else {
            System.out.println(name + " остался голодным(");
        }
    }

    public static void addFood(int quantutyFood) {
        System.out.println("В миску добавлено " + quantutyFood + " еды ");
        foodInBowl = foodInBowl + quantutyFood;
        System.out.println(getFoodInBowl());
    }
}

