package org.example;

import org.example.taskAnimal.Animal;
import org.example.taskAnimal.Cat;
import org.example.taskAnimal.Dog;
import org.example.taskInterface.RectangleImpl;
import org.example.taskInterface.SquareImpl;
import org.example.taskInterface.TriangleImpl;

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
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Кокос");
        cats[1] = new Cat("Гав");
        cats[2] = new Cat("Tом");
        cats[3] = new Cat("Леопольд");

        for (Cat cat : cats) {
            cat.toEat();
        }

        for (Cat catSatiety : cats) {
            catSatiety.infoSatietyCat();
        }

        System.out.println(Dog.getDogCounter());
        System.out.println(Cat.getCatCounter());
        System.out.println(Animal.getAnimalCounter());
        System.out.println(Cat.getFoodInBowl());

        SquareImpl square = new SquareImpl("Красный", "Синий", 10);
        System.out.println(square.infoFigure());

        TriangleImpl triangle = new TriangleImpl("Синий", "Желтый", 3, 2, 4);
        System.out.println(triangle.infoFigure());

        RectangleImpl rectangle = new RectangleImpl("red", "green", 4, 5);
        System.out.println(rectangle.infoFigure());
    }
}