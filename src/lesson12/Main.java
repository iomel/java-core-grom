package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank euBank = new EUBank(1231, "Ukraine", Currency.EUR, 1400, 120, 121, 100099990);
        Bank usBank = new USBank(1239, "Ukraine", Currency.USD, 800, 220, 11, 910099990);
        Bank chinaBank = new ChinaBank(1931, "Ukraine", Currency.EUR, 14000, 20, 3121, 10099990);

        User user1 = new User(1001, "Vasya", 400, 12, "IBM", 100, euBank);
        User user2 = new User(1091, "Petya", 1400, 32, "EBM", 70, usBank);
        User user3 = new User(1901, "Nasya", 7100, 52, "GOOGLE", 150, usBank);
        User user4 = new User(1009, "Vova", 20, 22, "RadioRynok", 10, euBank);
        User user5 = new User(1081, "Galya", 3900, 18, "VW", 1000, chinaBank);
        User user6 = new User(1801, "Tom", 1300, 42, "ASUS", 90, chinaBank);



        BankSystem bankSystem = new UkrainianBankSystem();
        System.out.println(user1.getBalance());
        bankSystem.withdraw(user1, 150);
        System.out.println(user1.getBalance());

        bankSystem.fund(user1, 21000);
        System.out.println(user1.getBalance());

    }
}
