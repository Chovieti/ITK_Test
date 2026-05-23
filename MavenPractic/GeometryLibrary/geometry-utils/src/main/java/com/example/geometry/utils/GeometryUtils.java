package com.example.geometry.utils;

import com.example.geometry.*;

public class GeometryUtils {
    public static double toSquareMeters(double areaInCm2) {
        return areaInCm2 / 10000.0;
    }

    public static int compareByArea(PerimeterAndArea c, PerimeterAndArea r) {
        double diff = c.getArea() - r.getArea();
        return diff < 0 ? -1 : (diff > 0 ? 1 : 0);
    }

    public static int compareByPerimeter(PerimeterAndArea c, PerimeterAndArea r) {
        double diff = c.getPerimeter() - r.getPerimeter();
        return diff < 0 ? -1 : (diff > 0 ? 1 : 0);
    }
}
