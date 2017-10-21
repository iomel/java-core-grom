package lesson22.task2;

public class Utils {

    private static int limitTransactionsPerDayCount = 15;
    private static int limitTransactionsPerDayAmount = 200;
    private static int limitSimpleTransactionAmount = 40;
    private static String[] cities = {"Kiev", "Odessa"};


    public static int getLimitTransactionPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public static int getLimitTransactionPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public static int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public static String[] getCities() {
        return cities;
    }
}
