package lesson10.abstractbigexample;

public abstract class Employee {
    private String name;
    private int age;
    private int salaryPerMonth;
    private int yearsOfExperience;

    private String curPosition;
    private BankAccount bankAccount;
    private Company[] companiesWorked = new Company[10];
    private String[] positionsWorked = new String[10];

    abstract void paySalary();

    void changePosition(String newPosition)
    {
        savePositionToHistory();
        curPosition = newPosition;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public String getName() {
        return name;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    private void savePositionToHistory()
    {
        int index = 0;
        for (String pos : positionsWorked) {
            if (pos == null) {
                positionsWorked[index] = curPosition;
                break;
            }
            index++;
        }

    }

    int getBalance()
    {
        return bankAccount.getBalance();
    }
}
