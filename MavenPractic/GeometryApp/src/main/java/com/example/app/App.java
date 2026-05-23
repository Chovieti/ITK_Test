package com.example.app;

import com.example.geometry.Cicrle;
import com.example.geometry.Rectangle;
import com.example.geometry.Triangle;

public class App
{
    public static void main(String[] args) {
        Cicrle cicrle = new Cicrle(5);
        System.out.printf("Круг: площадь = %.2f, периметр = %.2f%n",
                cicrle.getArea(), cicrle.getPerimeter());

        Rectangle rectangle = new Rectangle(3, 7);
        System.out.printf("Прямоугольник: площадь = %.2f, периметр = %.2f%n",
                rectangle.getArea(), rectangle.getPerimeter());

        Triangle triangle = new Triangle(3, 5, 7);
        System.out.printf("Треугольник: площадь = %.2f, периметр = %.2f%n",
                triangle.getArea(), triangle.getPerimerter());
    }
}
