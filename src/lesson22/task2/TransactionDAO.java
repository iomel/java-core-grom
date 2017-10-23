package lesson22.task2;

import lesson22.task2.exception.BadRequestException;
import lesson22.task2.exception.InternalServerException;
import lesson22.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {

    private static Transaction[] transactions = new Transaction[10];

    public static Transaction save (Transaction transaction) throws Exception
    {
        validate(transaction);

        for (int i = 0; i < transactions.length; i++)
            if (transactions[i] == null){
                transactions[i] = transaction;
                return transactions[i];
            }
        throw new InternalServerException("Unexpected error!  Transaction: " + transaction.getId());
    }

    public static Transaction[] transactionList() {
        int count = 0;
        for (Transaction tr : transactions)
            if (tr != null)
                count++;

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions)
            if (tr != null)
                result[index++] = tr;
        return result;
    }

    public static Transaction[] transactionList(String city) throws Exception  {
        if (city == null)
            throw new InternalServerException("Wrong [NULL] city in transactions filter!");

        int count = 0;
        for (Transaction tr : transactionList())
            if (tr.getCity().equals(city))
                count++;

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactionList())
            if (tr.getCity().equals(city))
                result[index++] = tr;
        return result;
    }

    public static Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction tr : transactionList())
            if (tr.getAmount() == amount)
                count++;

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactionList())
            if (tr.getAmount() == amount)
                result[index++] = tr;
        return result;
    }

    private static void validate (Transaction transaction) throws Exception {
        if (transaction == null)
            throw new InternalServerException("Transaction is NULL. Can't be saved" );

        if (transaction.getAmount() > Utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved" );

        int sum = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated()))
            sum += tr.getAmount();

        if (sum >= Utils.getLimitTransactionPerDayAmount())
            throw new LimitExceeded("Transaction amount per day limit exceeded " + transaction.getId() + ". Can't be saved" );

        if (getTransactionsPerDay(transaction.getDateCreated()).length >= Utils.getLimitTransactionPerDayCount())
            throw new LimitExceeded("Transaction count per day limit exceeded " + transaction.getId() + ". Can't be saved" );

        // check City payment
        boolean allowedCity = false;
        for (String city : Utils.getCities())
            if (city.equals(transaction.getCity()))
                allowedCity = true;
        if (!allowedCity)
            throw new BadRequestException("Transaction from this city is not allowed " + transaction.getId() + ". Can't be saved" );

        // check Space
        int  emptyPlaces = 0;
        for (Transaction tr : transactions)
            if (tr == null)
                emptyPlaces++;
        if (emptyPlaces == 0)
            throw new InternalServerException("Not enough space to save transaction " + transaction.getId() + ". Can't be saved" );
    }

    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for(Transaction transaction : transactionList()) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for(Transaction transaction : transactionList()) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    result[index++] = transaction;
            }
        return result;
    }

    public static void printTransactions () {
        for (Transaction tr : transactions)
            if (tr == null)
                System.out.print(" - EMPTY - ");
            else
                System.out.print("\n" + tr.toString());
        System.out.println();
    }

}
