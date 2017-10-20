package lesson20.task2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Transaction tr1 = new Transaction(1234, "Kiev", 15, "for coffe", TransactionType.INCOME, new Date());
        Transaction tr2 = new Transaction(1294, "Lvov", 15, "for the", TransactionType.INCOME, new Date());
        Transaction tr3 = new Transaction(1734, "Odessa", 150, "for XXX", TransactionType.INCOME, new Date());

        Transaction tr4 = new Transaction(1334, null, 15, "for", TransactionType.INCOME, new Date());
        Transaction tr5 = new Transaction(1214, "Kiev", 15, "for broad", TransactionType.INCOME, new Date());

        Controller controller = new Controller();

        // TEST 1
        System.out.println("TEST 1 add correct");
        try {
            controller.save(tr1);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        controller.printTransactions();

        // TEST 2
        System.out.println("\n\nTEST 2 add duplicated");

        try {
            controller.save(tr1);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        controller.printTransactions();

        // TEST 3
        System.out.println("\n\nTEST 3 limit amount Exceed");

        try {
            controller.save(tr3);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        controller.printTransactions();

        // TEST 4
        System.out.println("\n\nTEST 4 wrong city");

        try {
            controller.save(tr2);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        controller.printTransactions();

        // TEST 5
        System.out.println("\n\nTEST 5 amount not enough");

        for (int i = 0; i < 12 ; i++)
        try {
            controller.save(new Transaction(1235 + i*3, "Kiev", 15 , "for coffe", TransactionType.INCOME, new Date()));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        controller.printTransactions();

        // TEST 6
        System.out.println("\n\nTEST 6 places not enough");

        for (int i = 0; i < 12 ; i++)
            try {
                controller.save(new Transaction(1225 + i*4, "Kiev", 1 , "for coffe", TransactionType.INCOME, new Date()));
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        controller.printTransactions();

        // TEST 7
        System.out.println("\n\nTEST 7 count limit");

            try {
                controller.save(new Transaction(9225 , "Kiev", 1 , "for coffe", TransactionType.INCOME, new Date()));
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        controller.printTransactions();

    }
}
