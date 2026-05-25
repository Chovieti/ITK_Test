package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = createOrder();
        outputForAll(orders);
        outputForEach(orders);
    }

    private static List<Order> createOrder() {
        // Вариант с билдером неуверен насколько нужно, но вместо создания списка выше можно его использовать
        Stream.Builder<Order> builder = Stream.builder();
        return builder
                .add(new Order("Laptop", 1200.0))
                .add(new Order("Smartphone", 800.0))
                .add(new Order("Laptop", 1500.0))
                .add(new Order("Tablet", 500.0))
                .add(new Order("Smartphone", 900.0))
                .build().toList();
    }

    private static void outputForAll(List<Order> orders) {
        System.out.println(
                orders.stream()
                        .collect(
                                groupingBy(  // Группировка по именам продуктов
                                        Order::getProduct,
                                        summingDouble(Order::getCost)    // Складывание стоимости заказов каждого продукта
                                )
                        ).entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))  // Сортировка по убыванию стоимости
                        .limit(3)   // Выбор 3
                        .collect(teeing(
                                mapping(Map.Entry::getKey, joining(", ")),  // Собираю названия в одну строку
                                summingDouble(Map.Entry::getValue), // Суммирую их общую стоимость
                                (product, value) -> String.format("Топ продуктов - %s. Их общая стоимость - %.2f",
                                        product, value)
                        )).toString());
    }

    private static void outputForEach(List<Order> orders) {
        orders.stream()
                .collect(
                        groupingBy(  // Группировка по именам продуктов
                                Order::getProduct,
                                summingDouble(Order::getCost)    // Складывание стоимости заказов каждого продукта
                        )
                ).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))  // Сортировка по убыванию стоимости
                .limit(3)
                .forEach(System.out::println);
    }
}
