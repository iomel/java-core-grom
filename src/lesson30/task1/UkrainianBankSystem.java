package lesson30.task1;

import java.util.*;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();
    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount*user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "withdraw");
    }

    private boolean checkWithdraw(User user, int amount)
    {
        return (checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance()));

    }

    private boolean checkWithdrawLimits(User user, int amount, double limit)
    {
        if (amount + amount * user.getBank().getCommission(amount)> limit) {
            printWithdrawalErrorMsg(user, amount);
            return false;
        }
        return true;
    }

    private void printWithdrawalErrorMsg(User user, int amount)
    {
        System.err.println("Can't withdraw  money " + amount + " from user " + user.toString());
    }

    @Override
    public void fund(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding())
            return;
        else
            user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "put money");

    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount))
            return;
        if (amount > toUser.getBank().getLimitOfFunding())
            return;
        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency())
            return;
        this.withdraw(fromUser, amount);
        toUser.setBalance(toUser.getBalance() + amount);
        createAndSaveTransaction(new Date(), TransactionType.TRANSFER, amount, "transfered");
    }

    @Override
    public void paySalary(User user) {
        if (user.getSalary() > user.getBank().getLimitOfFunding())
            return;

        user.setBalance(user.getBalance() + user.getSalary());
        createAndSaveTransaction(new Date(), TransactionType.SALATY_INCOME, user.getSalary(), "salary income");

    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String description) {
        Random random = new Random();
        Transaction tr = new Transaction(random.nextLong(), dateCreated, null, type, amount, description);
        transactions.add(tr);

        return tr;

    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
