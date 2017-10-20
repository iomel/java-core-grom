package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save (Transaction transaction) throws Exception
    {
        return transactionDAO.save(transaction);
    }

    public Transaction[] transactionList() throws InternalServerException
    {
        return transactionDAO.transactionList();
    }

    public Transaction[] transactionList(String city) throws BadRequestException
    {
        return transactionDAO.transactionList(city);
    }

    public Transaction[] transactionList(int amount)
    {
        return transactionDAO.transactionList(amount);
    }



}
