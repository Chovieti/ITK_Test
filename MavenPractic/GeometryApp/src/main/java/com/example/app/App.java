package com.example.app;

import com.example.geometry.Cicrle;
import com.example.geometry.Rectangle;
import com.example.geometry.Triangle;

public class App
{
    public static void main(String[] args) {
        Cicrle cicrle = new Cicrle(5);
        System.out.print(cicrle);

        Rectangle rectangle = new Rectangle(3, 7);
        System.out.print(rectangle.toString());

        Triangle triangle = new Triangle(3, 5, 7);
        System.out.print(triangle.toString());
    }
}
