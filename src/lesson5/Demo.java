package lesson5;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        // ArrayPractice tests
        ArraysPractice arr = new ArraysPractice();
        int[] array = {-10, 0, 110, 555, 1000, -45, 0, 60};
        System.out.println(arr.maxElement(array));
        System.out.println(arr.nCount(array, 0));

        int[] array1 = new int[8];
        System.out.println(arr.maxElement(array1));
        System.out.println(arr.nCount(array1, 10));

        System.out.println(arr.maxElement(null));
        System.out.println(arr.nCount(null, 10));

        //Bank Practice tests
        BanksPractice bank = new BanksPractice();
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(Arrays.toString(bank.findClientsByBalance(names, balances, -100)));
        System.out.println(Arrays.toString(bank.findClientsWithNegativeBalance(names, balances)));
        System.out.println(Arrays.toString(bank.findClientsByBalance(null, balances, 100)));
        System.out.println(Arrays.toString(bank.findClientsWithNegativeBalance(names, null)));
        System.out.println(Arrays.toString(bank.findClientsByBalance(names, null, 100)));
        System.out.println(Arrays.toString(bank.findClientsWithNegativeBalance(null, balances)));


        bank.depositMoney(names, balances, "Ann", 2000);
        System.out.println(Arrays.toString(balances));
        bank.depositMoney(names, balances, null, 2000);
        System.out.println(Arrays.toString(balances));
        bank.depositMoney(names, balances, "Nikolay", -2000000);
        System.out.println(Arrays.toString(balances));


        System.out.println(bank.withdraw(names,balances, "Ann", 10000));
        System.out.println(bank.withdraw(names,balances, "Ann", 1000));
        System.out.println(bank.withdraw(names,balances, null, -10000));
        System.out.println(bank.withdraw(names,balances, "Nikolay", -1000));

        SortArray sort = new SortArray();
        sort.sortAscending(array);
        sort.sortDescending(array);
        sort.sortDescending(array1);

        UnicCount uc = new UnicCount();

        System.out.println(Arrays.toString(array));
        System.out.println(uc.uniqueCount(array));
        System.out.println(uc.uniqueCount(null));

        System.out.println(uc.uniqueCount(array1));

    }
}
