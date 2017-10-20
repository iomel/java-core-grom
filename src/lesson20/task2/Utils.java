package lesson20.task2;

public class Utils {

    private int limitTransactionsPerDayCount = 10;
    private int limitTransactionsPerDayAmount = 100;
    private int limitSimpleTransactionsAmount = 40;
    private String[] cities = {"Kiev", "Odessa"};

    public int getLimitTransactionPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionsAmount;
    }

    public String[] getCities() {
        return cities;
    }
}