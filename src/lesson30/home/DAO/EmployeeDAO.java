package lesson30.home.DAO;

import lesson30.home.Employee;
import lesson30.home.enams.DepartmentType;
import lesson30.home.enams.Position;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {

    {init();}

    private static Set<Employee> employees = new HashSet<>();

    public static Employee add (Employee e){
        employees.add(e);
        return e;
    }

    public static void remove (Employee e){
        employees.remove(e);
    }

    public static Employee getById (long id){
        //TODO
        return null;
    }

    public static Set<Employee> getByPosition (Position position){
        //TODO
        return null;
    }

    public static Set<Employee> getByDepartment(DepartmentType depType){
        //TODO
        return null;
    }

    public static Set<Employee> getEmployees() {
        return employees;
    }

    private static void init(){
        Employee emp1 = new Employee(1234, "Vasya", "Pupkin", new Date(), Position.TEAM_LEAD);
        Employee emp2 = new Employee(1235, "Vova", "Chopin", new Date(), Position.DEVELOPER);
        Employee emp3 = new Employee(1236, "Anrdey", "Komin", new Date(), Position.TEAM_LEAD);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
    }

}
