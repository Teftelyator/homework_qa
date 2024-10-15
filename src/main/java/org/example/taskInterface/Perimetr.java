package org.example.taskInterface;

public interface Perimetr {
     default double perimetr(double width, double height) {
        return (width + height) * 2;
    }
}
