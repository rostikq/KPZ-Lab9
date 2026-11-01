package io.github.rostikq;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class VanPool {

    private static class Van {
        private final int id;
        private String courier;
        private String shipment;
        private int completedTrips;

        public Van(int id) {
            this.id = id;
        }

        public void assign(String courier, String shipment) {
            this.courier = courier;
            this.shipment = shipment;
            System.out.println(
                    "Фургон #" + id
                            + " призначено кур'єру " + courier
                            + ", відправлення: " + shipment
            );
        }

        public void completeTrip() {
            completedTrips++;

            System.out.println(
                    "Фургон #" + id
                            + " завершив рейс кур'єра " + courier
            );
        }

        public void reset() {
            courier = null;
            shipment = null;

            System.out.println(
                    "Фургон #" + id
                            + " очищено та підготовлено до повторного використання"
            );
        }

        public int getId() {
            return id;
        }

        public int getCompletedTrips() {
            return completedTrips;
        }
    }

    private final Queue<Van> availableVans = new ArrayDeque<>();
    private final List<Van> allVans = new ArrayList<>();
    private final Queue<String> waitingCouriers = new ArrayDeque<>();

    public VanPool(int capacity) {
        System.out.println("Створення пулу фургонів...");

        for (int i = 1; i <= capacity; i++) {
            Van van = new Van(i);
            availableVans.offer(van);
            allVans.add(van);

            System.out.println("Створено фургон #" + i);
        }
    }

    public Van acquire(String courier, String shipment) {
        Van van = availableVans.poll();

        if (van == null) {
            waitingCouriers.offer(courier);

            System.out.println(
                    "Немає вільного фургона. Кур'єр "
                            + courier + " очікує."
            );

            return null;
        }

        van.assign(courier, shipment);
        return van;
    }

    public void release(Van van) {
        if (van == null) {
            return;
        }

        van.completeTrip();
        van.reset();
        availableVans.offer(van);

        // Якщо є кур'єр у черзі — одразу передаємо йому фургон
        String nextCourier = waitingCouriers.poll();

        if (nextCourier != null) {
            Van reusedVan = availableVans.poll();

            if (reusedVan != null) {
                reusedVan.assign(
                        nextCourier,
                        "Відправлення кур'єра " + nextCourier
                );
            }
        }
    }

    public void printStatistics() {
        System.out.println("\nСтатистика фургонів:");

        for (Van van : allVans) {
            System.out.println(
                    "Фургон #" + van.getId()
                            + ": завершено рейсів — "
                            + van.getCompletedTrips()
            );
        }

        System.out.println("Усього створено фургонів: " + allVans.size());
    }

    public static void runDemo() {
        System.out.println("\n========== OBJECT POOL ==========");

        VanPool pool = new VanPool(3);

        Van van1 = pool.acquire("Іван", "Посилка-101");
        Van van2 = pool.acquire("Петро", "Посилка-102");
        Van van3 = pool.acquire("Олександр", "Посилка-103");

        // Фургонів немає — кур'єри очікують
        pool.acquire("Андрій", "Посилка-104");
        pool.acquire("Марія", "Посилка-105");

        System.out.println("\nПовернення фургона в пул:");
        pool.release(van1);

        System.out.println("\nПовернення інших фургонів:");
        pool.release(van2);
        pool.release(van3);

        pool.printStatistics();
    }
}