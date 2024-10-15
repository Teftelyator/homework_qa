package org.example.taskAnimal;

public abstract class Animal {
    public static int animalCounter;
    String name;

    public Animal(String name) {
        this.name = name;
        animalCounter += 1;
    }

    public static String getAnimalCounter() {
        return "Животных всего создано : " + animalCounter;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
