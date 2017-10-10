package lesson8.accounts;

public class Demo {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount("SomeBank", "Denis", 1000, 50);
        savingAccount.depositMoney(100);

        savingAccount.changeOwnerName("Oleg");

        System.out.println(savingAccount.ownerName);

        CheckingAccount checkingAccount = new CheckingAccount("SomeBank", "Denis", 1000, 100);
        checkingAccount.changeOwnerName("Oleg");

        System.out.println(checkingAccount.ownerName);

    }
}
