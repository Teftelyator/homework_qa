package org.example;

public class Animal {

    public static int animalCounter;
    String name;

    public Animal(String name) {
        this.name = name;
        animalCounter += 1;
    }

    public static int getAnimalCounter() {
        return animalCounter;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " метров");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " метров");

    }
}
