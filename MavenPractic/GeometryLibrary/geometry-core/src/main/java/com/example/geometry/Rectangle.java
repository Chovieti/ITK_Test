package com.example.geometry;

public class Rectangle implements PerimeterAndArea {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник. Площадь - %.2f, периметр - %.2f%n", getArea(), getPerimeter());
    }
}
