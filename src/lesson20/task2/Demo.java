package lesson20.task2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Transaction tr1 = new Transaction(1234, "Kiev", 15, "for coffe", TransactionType.INCOME, new Date());
    }
}
