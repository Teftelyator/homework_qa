package org.example.taskInterface;

public class RectangleImpl implements Area,Perimetr {
    String fillColor;
    String backgroundColor;
    double height;
    double wight;

    public RectangleImpl(String fillColor,  String backgroundColor, double wight,double height) {
        this.fillColor = fillColor;
        this.backgroundColor = backgroundColor;
        this.height = height;
        this.wight = wight;
    }



    @Override
    public double area() {
        return height*wight;
    }

    @Override
    public double perimetr() {
        return (height*2) + (wight*2);
    }


    public String infoFigure() {
        return "Характеристики прямоугольника:"+ '\n' +
                "Цвет границ : " + fillColor + '\n' +
                "Цвет фона : " + backgroundColor + '\n' +
                "Площадь : " + area()+ '\n' +
                "Периметр : " + perimetr() ;
    }
}
