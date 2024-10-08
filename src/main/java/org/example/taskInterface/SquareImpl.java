package org.example.taskInterface;

public class SquareImpl implements Area, Perimetr {

    String fillColor;
    String backgroundColor;
    public double radius;


    public String infoFigure() {
        return "Характеристики круга :" +
                "Цвет границ : " + fillColor + '\n' +
                "Цвет фона : " + backgroundColor + '\n' +
                "Радиус : " + radius + '\n'+ "Площадь :" + area()+ '\n' +
                "Периметр : " + perimetr();
    }

    public SquareImpl(String fillColor, String backgroundColor, double radius) {
        this.fillColor = fillColor;
        this.backgroundColor = backgroundColor;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public double perimetr() {
        return Math.PI * 2 * radius;
    }
}
