package lesson5;

public class Bank {
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
            balances[clientIdex] -= amount;
        else
            return -1;

        return balances[clientIdex];
    }

}
