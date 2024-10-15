package org.example.taskAnimal;

public class Bowl {
    private static int foodInBowl;

    public static void setFoodInBowl(int foodInBowl) {
        Bowl.foodInBowl = foodInBowl;
    }

    public static int getFoodInBowl() {
        return foodInBowl;
    }

    public static void bowlInfo() {
        System.out.println("Корма в миске :" + getFoodInBowl());
    }

    public static void addFood(int quantutyFood) {
        System.out.println("В миску добавлено " + quantutyFood + " еды ");
        foodInBowl = foodInBowl + quantutyFood;
        bowlInfo();
    }
}
