package org.example.taskAnimal;

public class Dog extends Animal {
    private static int dogCounter;

    public Dog(String name) {
        super(name);
        dogCounter += 1;
    }

    public static String getDogCounter() {
        return "Собак всего создано " + dogCounter;
    }

    public void swim(int distance) {
        if (distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println("Собака не может проплыть больше 10 метров");
        }
    }

    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.println("Собака не может пробежать больше 500 метров");
        }
    }
}
