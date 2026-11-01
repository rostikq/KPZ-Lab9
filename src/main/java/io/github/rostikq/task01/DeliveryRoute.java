package io.github.rostikq.task01;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DeliveryRoute {
    private String name;
    private String courier;
    private double maxWeight;
    private List<String> stops;
    private Map<String, Double> tariffs;

    public DeliveryRoute(
            String name,
            String courier,
            double maxWeight,
            List<String> stops,
            Map<String, Double> tariffs
    ) {
        this.name = name;
        this.courier = courier;
        this.maxWeight = maxWeight;
        this.stops = new ArrayList<>(stops);
        this.tariffs = new LinkedHashMap<>(tariffs);
    }

    // Prototype: створення незалежної копії маршруту
    public DeliveryRoute copy() {
        return new DeliveryRoute(
                name,
                courier,
                maxWeight,
                stops,
                tariffs
        );
    }

    public void addStop(String stop) {
        stops.add(stop);
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void printInfo() {
        System.out.println("Маршрут: " + name);
        System.out.println("Кур'єр: " + courier);
        System.out.println("Максимальна вага: " + maxWeight + " кг");
        System.out.println("Зупинки: " + stops);
        System.out.println("Тарифи: " + tariffs);
        System.out.println();
    }
}
