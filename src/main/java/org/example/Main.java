package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Иван Иванович", "Менеджер", "ivan@mail", "+7-912-312-32-32", 22000, 32);
        employees[1] = new Employee("Иванов Василий Иванович", "Директор", "vasiliy@mail", "+8-923-919-23-11", 22000, 31);
        employees[2] = new Employee("Иванов Федор Иванович", "Оператор", "fedor@mail", "+8-923-919-22-84", 22000, 22);
        employees[3] = new Employee("Иванов Петр Иванович", "Водитель", "petr@mail", "+8-923-919-22-13", 22000, 5);
        employees[4] = new Employee("Иванов Иван Петрович", "Зам зама", "petrovich@mail", "+8-923-948-21-83", 22000, 62);


        employees[0].employeeInfo();

        System.out.println("______________________");

        List<Park.Attraction> list = new ArrayList<>();
        list.add(new Park.Attraction("Emelya", "10.00-20.00", 100));
        list.add(new Park.Attraction("Romashka", "10.00-18.00", 200));
        list.add(new Park.Attraction("Carousel", "10.00-11.00", 1500));
        Park park = new Park("malinki", list);
        for (Park.Attraction attraction : list) {
            System.out.println("Name : " + attraction.getAttractionName());
            System.out.println("Working hours : " + attraction.getWorkingHours());
            System.out.println("Cost : " + attraction.getCost());
            System.out.println("_________________________________");
        }

    }
}