package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(sumInRange(33,25));
        printNumIsPositive(-3);
        System.out.println(booleanNumIsPositive(-3));
        repeatString("Пример строки", 3);
        System.out.println(leapYear(100));
        replacingNumber();
        fillInArray();
        multiplyNumbers();
        fillInElements();
        createArray(3,5);
    }

    public static void printThreeWords() {
        System.out.println("Orange" );
        System.out.println("Banana" );
        System.out.println("Apple" );
    }

    public static void checkSumSign() {
        int a = 3;
        int b = 15453;

        if(a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
        System.out.println("Сумма отрицательная");}
    }

    public static void  printColor() {
        int value = 0;

        if (value<=0) {
            System.out.println("Красный");
        }else if(value>100) {
            System.out.println("Зеленый");
        }else {
            System.out.println("Желтый");
        }
    }

    public static void compareNumbers() {
        int a = 23;
        int b = 34;

        if (a>=b) {
            System.out.println("a >= b");
        }else {
            System.out.println("a < b");
        }
    }

    public static boolean sumInRange(int num1, int num2) {
        int sum = num1 + num2;
        return sum >= 10 && sum <= 20;
    }

    public static void printNumIsPositive(int x) {
        if (x < 0) {
            System.out.println("Число отрицательное");
        }else {
            System.out.println("Число положительное");
        }
    }

    public static boolean booleanNumIsPositive(int a) {
        return a < 0;
    }

    public static void repeatString (String exampleString, int repeatValue) {
        for (int i = 0; i <repeatValue ; i++) {
            System.out.println(exampleString);
        }
    }

    public static boolean leapYear (int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ;
    }

    public static void replacingNumber () {
        int [] array = {1, 1, 0, 0, 1, 1, 0, 0};

        System.out.println("Исходный массив : " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            }else {
                array[i] = 0;
            }
            
        }
        System.out.println("Измененный массив : " + Arrays.toString(array));
    }

    public static void fillInArray () {
        int [] array = new int[100];
        int x = 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = x;
            x++;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void multiplyNumbers() {
        int [] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Исходный массив : " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if(array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        System.out.println("Измененный массив" + Arrays.toString(array));
    }

    public static void fillInElements() {
        int size = 3;
        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
            array[i][size - i - 1] = 1;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        System.out.println(Arrays.toString(array));
    }
}