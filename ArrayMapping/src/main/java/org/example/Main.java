package org.example;

import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Integer[] arrayInt = new Integer[5];
        for (int i = 0; i < 5; i++) {
            arrayInt[i] = i + 1;
        }
        System.out.println("Стартовый массив целых чисел");
        arrayOutput(arrayInt);
        System.out.println("Массив целых чисел возведенных в квадрат");
        arrayOutput(arrayMapping(arrayInt, k -> k * k));

        Double[] arrayDouble = new Double[5];
        for (int i = 0; i < 5; i++) {
            arrayDouble[i] = i + 10.0;
        }
        System.out.println("Стартовый массив вещественных чисел");
        arrayOutput(arrayDouble);
        System.out.println("Массив корней из вещественных чисел");
        arrayOutput(arrayMapping(arrayDouble, Math::sqrt));
    }

    private static <T> T[] arrayMapping(T[] array, Function<T, T> map) {
        T[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            result[i] = map.apply(result[i]);
        }
        return result;
    }

    private static <T> void arrayOutput(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].toString() + " ");
        }
        System.out.println();
    }
}