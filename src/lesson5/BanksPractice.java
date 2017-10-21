package lesson5;

import java.util.Arrays;

public class BanksPractice {

    public String[] findClientsByBalance(String[] clients, int[] balances, int n)
    {
        int count = 0;
        for (int balance : balances)
            if (balance >= n)
                count++;

        String[] results = new String[count];
        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance >= n) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    public String[] findClientsWithNegativeBalance(String[] clients, int[] balances)
    {
        int count = 0;
        for (int balance : balances)
            if (balance < 0)
                count++;

        String[] results = new String[count];
        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance < 0) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }


    void depositMoney(String[] clients, int[] balances, String client, int money)
    {
        balances[findClientIndexByName(clients,client)] += calculateDepositAmountAfterCommission(money);
    }

    int withdraw(String[] clients, int[] balances, String client, int amount)
    {
        int clientIdex = 0;

        for (String cl : clients)
        {
            if (cl == client)
                break;
            clientIdex++;
        }
        if (balances[clientIdex] >= amount )
            return balances[clientIdex] - amount;
        else
            return -1;
    }
    int findClientIndexByName(String[] clients, String client)
    {
        int clientIdex = 0;

        for (String cl : clients)
        {
            if (cl == client)
                break;
            clientIdex++;
        }
        return clientIdex;
    }

    int calculateDepositAmountAfterCommission(int money)
    {
        return money <= 100 ? (int)(money - money * 0.02) : (int)(money - money * 0.01);
    }
}
