import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class Order {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }
}

public class NumberGenerator {

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
        // Вариант с билдером неуверен насколько нужно, но вместо создания списка выше можно его использовать
//        Stream.Builder<Order> builder = Stream.builder();
//        List<Order> orders = builder
//                .add(new Order("Laptop", 1200.0))
//                .add(new Order("Smartphone", 800.0))
//                .add(new Order("Laptop", 1500.0))
//                .add(new Order("Tablet", 500.0))
//                .add(new Order("Smartphone", 900.0))
//                .build().toList();
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
}
