package org.example.taskInterface;

public class TriangleImpl implements Area, Perimetr {

    String fillColor;
    String backgroundColor;
    public double a;
    public double b;
    public double c;

    public TriangleImpl(String fillColor, String backgroundColor, double a, double b, double c) {
        this.fillColor = fillColor;
        this.backgroundColor = backgroundColor;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimetr() {
        return a + b + c;
    }

    @Override
    public double area() {
        double p = perimetr() / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }


    public String infoFigure() {
        return "Характеристики треугольника :"+ '\n' +
                "Цвет границ : " + fillColor + '\n' +
                "Цвет фона : " + backgroundColor + '\n' +
                 "Площадь :" + area()+ '\n' +
                "Периметр : " + perimetr() ;
    }
}
