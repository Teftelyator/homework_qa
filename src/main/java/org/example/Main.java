package org.example;

public class Main {
    public static void main(String[] args) {
        ExceptionTask exceptionTask = new ExceptionTask();
        String[][] array = {{"2", "3", "6", "11"}, {"8", "3", "s", "11"}, {"244", "5", "6", "8"}, {"13", "7", "332", "11"}};
        try {
            try {
                System.out.println(exceptionTask.arrayMethod(array));
            } catch (MyArraySizeException ase) {
                System.out.println("Массив не соответствует размеру 4х4");
            }
        } catch (MyArrayDataException ade) {
            System.out.println("Преобразование не удалось!!!" + '\n' + "Неверные данные в ячейке :" + ade.i + "x" + ade.j);
        }
    }
}