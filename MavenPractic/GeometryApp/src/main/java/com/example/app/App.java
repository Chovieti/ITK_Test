package com.example.app;

import com.example.geometry.Cicrle;
import com.example.geometry.PerimeterAndArea;
import com.example.geometry.Rectangle;
import com.example.geometry.Triangle;
import com.example.geometry.utils.GeometryUtils;

public class App
{
    public static void main(String[] args) {
        Cicrle cicrle = new Cicrle(5);
        System.out.print(cicrle);
        System.out.printf("Площадь круга в м² - %.4f%n", GeometryUtils.toSquareMeters(cicrle.getArea()));

        Rectangle rectangle = new Rectangle(3, 7);
        System.out.print(rectangle.toString());

        Triangle triangle = new Triangle(3, 5, 7);
        System.out.print(triangle.toString());
        switch (GeometryUtils.compareByArea((PerimeterAndArea) rectangle, (PerimeterAndArea) triangle)) {
            case 0 -> System.out.println("Площадь прямоугольника и треугольника равны");
            case 1 -> System.out.println("Площадь прямоугольника больше площади треугольника");
            case -1 -> System.out.println("Площадь прямоугольника меньше площади треугольника");
        }
        switch (GeometryUtils.compareByPerimeter((PerimeterAndArea) rectangle, (PerimeterAndArea) triangle)) {
            case 0 -> System.out.println("Периметр прямоугольника и треугольника равны");
            case 1 -> System.out.println("Периметр прямоугольника больше площади треугольника");
            case -1 -> System.out.println("Периметр прямоугольника меньше площади треугольника");
        }
    }
}
