package org.example;

public class Main {
    public static void main(String[] args) {
        UndoStringBuilder builder = new UndoStringBuilder("Hello");
        System.out.println("Строка в начале - " + builder.toString());
        builder.append(" World!");
        System.out.println("Строка после добавления - " + builder.toString());
        builder.append(" Goodbye!");
        System.out.println("Строка после ещё одного добавления - " + builder.toString());
        builder.undo();
        System.out.println("Строка после отмены - " + builder.toString());
        builder.append(" And everything!");
        System.out.println("Строка после ещё одного добавления - " + builder.toString());
        builder.undo();
        System.out.println("Строка после отмены - " + builder.toString());
        builder.undo();
        System.out.println("Строка после ещё одной отмены - " + builder.toString());
    }
}