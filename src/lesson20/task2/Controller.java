package lesson20.task2;

import lesson20.task2.exception.BadRequestException;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save (Transaction transaction) throws Exception
    {
        return transactionDAO.save(transaction);
    }

    public Transaction[] transactionList()
    {
        return transactionDAO.transactionList();
    }

    public Transaction[] transactionList(String city) throws Exception
    {
        return transactionDAO.transactionList(city);
    }

    public Transaction[] transactionList(int amount)
    {
        return transactionDAO.transactionList(amount);
    }

    public void printTransactions ()
    {
        transactionDAO.printTransactions();
    }


}
