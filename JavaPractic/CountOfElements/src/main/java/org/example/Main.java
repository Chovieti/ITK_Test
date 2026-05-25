package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Integer[] arrayInt = new Integer[]{1, 1, 2, 3, 4, 3, 2, 2, 5, 6, 6, 3};
        System.out.print("Изначальный массив целых чисел - ");
        outputArray(arrayInt);
        System.out.println("Мапа на основе массива целых чисел");
        outputMap(countOfElements(arrayInt));
        String[] arrayString = new String[]{"Hello", "Record", "Bye", "Hello", "Record", "Map", "Hello", "Map"};
        System.out.print("Изначальный массив строк - ");
        outputArray(arrayString);
        System.out.println("Мапа на основе массива строк");
        outputMap(countOfElements(arrayString));
    }

    private static <T> void outputArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].toString() + " ");
        }
        System.out.println();
    }

    private static <T> void outputMap(Map<T, Integer> map) {
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            System.out.println("Элемент - " + entry.getKey().toString() + " встречает - " + entry.getValue() + " раз");
        }
    }

    private static <T> Map<T, Integer> countOfElements(T[] array) {
        Map<T, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.merge(array[i], 1, Integer::sum);
        }
        return map;
    }
}