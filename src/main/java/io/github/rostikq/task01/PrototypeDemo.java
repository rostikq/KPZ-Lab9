package io.github.rostikq.task01;

import java.util.List;
import java.util.Map;

public class PrototypeDemo {

    public static void run() {
        System.out.println("\n========== PROTOTYPE ==========");

        System.out.println("Створення шаблону маршруту...");
        simulateExpensiveOperation();

        DeliveryRoute template = new DeliveryRoute(
                "Чернівці – Хотин – Кельменці",
                "Не призначено",
                1000,
                List.of("Чернівці", "Хотин", "Кельменці"),
                Map.of(
                        "Стандартна посилка", 50.0,
                        "Велика посилка", 100.0
                )
        );

        DeliveryRoute monday = template.copy();
        DeliveryRoute tuesday = template.copy();
        DeliveryRoute wednesday = template.copy();

        monday.setCourier("Іван");
        tuesday.setCourier("Петро");
        wednesday.setCourier("Олександр");

        // Змінюємо тільки маршрут вівторка
        tuesday.addStop("Новоселиця");
        tuesday.setMaxWeight(1500);
        tuesday.setCourier("Андрій");

        System.out.println("\nМаршрут на понеділок:");
        monday.printInfo();

        System.out.println("Маршрут на вівторок:");
        tuesday.printInfo();

        System.out.println("Маршрут на середу:");
        wednesday.printInfo();

        System.out.println("Оригінальний шаблон:");
        template.printInfo();
    }

    private static void simulateExpensiveOperation() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
