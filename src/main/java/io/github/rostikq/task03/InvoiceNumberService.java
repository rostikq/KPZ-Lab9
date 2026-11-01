package io.github.rostikq.task03;

public class InvoiceNumberService {

    private static final InvoiceNumberService INSTANCE =
            new InvoiceNumberService();

    private int nextNumber = 1;

    private InvoiceNumberService() {
        System.out.println(
                "Ініціалізовано єдиний сервіс нумерації відправлень."
        );
    }

    public static InvoiceNumberService getInstance() {
        return INSTANCE;
    }

    public synchronized String generateNumber() {
        return String.format("POS-%04d", nextNumber++);
    }
}
