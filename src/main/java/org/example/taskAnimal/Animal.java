package org.example.taskAnimal;

public class Animal {
    public static int animalCounter;
    String name;

    public Animal(String name) {
        this.name = name;
        animalCounter += 1;
    }

    public static String getAnimalCounter() {
        return "Животных всего создано : " + animalCounter;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м");

    }
}
