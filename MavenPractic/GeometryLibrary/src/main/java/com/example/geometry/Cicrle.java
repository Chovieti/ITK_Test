package com.example.geometry;

public class Cicrle {
    private double radius;

    public Cicrle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Круг. Площадь - %.2f, периметр - %.2f%n", getArea(), getPerimeter());
    }
}
