package io.github.rostikq.task03;

public class SingletonDemo {

    public static void run() {
        System.out.println("\n========== SINGLETON ==========");

        InvoiceNumberService branch1 =
                InvoiceNumberService.getInstance();

        InvoiceNumberService branch2 =
                InvoiceNumberService.getInstance();

        InvoiceNumberService onlineCabinet =
                InvoiceNumberService.getInstance();

        System.out.println(
                "Відділення №1 та №2 використовують один сервіс: "
                        + (branch1 == branch2)
        );

        System.out.println(
                "Відділення №1 та онлайн-кабінет використовують один сервіс: "
                        + (branch1 == onlineCabinet)
        );

        System.out.println("\nВідділення №1 створює відправлення:");

        for (int i = 0; i < 3; i++) {
            System.out.println(branch1.generateNumber());
        }

        System.out.println("\nВідділення №2 створює відправлення:");

        for (int i = 0; i < 3; i++) {
            System.out.println(branch2.generateNumber());
        }

        System.out.println("\nОнлайн-кабінет створює відправлення:");

        for (int i = 0; i < 3; i++) {
            System.out.println(onlineCabinet.generateNumber());
        }
    }
}
