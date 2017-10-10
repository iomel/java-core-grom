package lesson8.accounts;

public class CheckingAccount extends Account {
    int limitOfExpeses;

    public CheckingAccount(String bankName, String ownerName, int moneyAmount, int limitOfExpeses) {
        super(bankName, ownerName, moneyAmount);
        this.limitOfExpeses = limitOfExpeses;
    }

    void withdraw(int amount)
    {
        if (amount > limitOfExpeses)
            return;
        moneyAmount -= amount;
    }


}
