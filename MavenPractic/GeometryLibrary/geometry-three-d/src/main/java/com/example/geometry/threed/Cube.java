package com.example.geometry.threed;

public class Cube implements VolumeAndSurfaceArea {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public double getSurfaceArea() {
        return 6 * side * side;
    }

    @Override
    public String toString() {
        return String.format("Куб. Объём - %.2f, площадь поверхности - %.2f%n",
                getVolume(), getSurfaceArea());
    }
}