package lesson10.abstractbigexample;

public class EmployeeController {
    private Employee[] employees = new Employee[100];

    void paySalaryToEmployees()
    {
        for (Employee e : employees){
            e.paySalary();
            System.out.println("Salary was payed successfully to " + e.getName() + "employee" );
        }
    }
}
