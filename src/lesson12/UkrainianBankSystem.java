package lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount*user.getBank().getCommission(amount));
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
    }

    @Override
    public void paySalary(User user) {
        if (user.getSalary() > user.getBank().getLimitOfFunding())
            return;

        user.setBalance(user.getBalance() + user.getSalary());
    }
}
