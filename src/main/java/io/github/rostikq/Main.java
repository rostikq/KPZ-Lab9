package io.github.rostikq;

import io.github.rostikq.task01.PrototypeDemo;
import io.github.rostikq.task03.SingletonDemo;

public class Main {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" СЛУЖБА ДОСТАВКИ «ПОСИЛКА+»");
        System.out.println(" Лабораторна робота №9");
        System.out.println(" Породжувальні шаблони проєктування");
        System.out.println("======================================");

        // Завдання 1 — Prototype
        PrototypeDemo.run();

        // Завдання 2 — Object Pool
        VanPool.runDemo();

        // Завдання 3 — Singleton
        SingletonDemo.run();

        System.out.println("\nУсі завдання виконано.");
    }
}