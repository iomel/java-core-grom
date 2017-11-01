package lesson30.home;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {

    private static Set<Employee> employees = new HashSet<>();

    public static Employee add (Employee employee){
        if (employee != null)
            employees.add(employee);
        return employee;
    }

    public static void remove (Employee e){
        employees.remove(e);
    }

    public static Employee getById (long id){
        for (Employee e : employees)
            if (e != null && e.getId() == id)
                return e;
        return null;
    }

    public static Set<Employee> getByPosition (Position position){
        Set<Employee> result = new HashSet<>();
        for (Employee e : employees)
            if (e != null && e.getPosition() == position)
                result.add(e);
        return result;
    }

    public static Set<Employee> getByDepartment(DepartmentType depType){
        Set<Employee> result = new HashSet<>();
        for (Employee e : employees)
            if (e != null && e.getDepartment().getType() == depType)
                result.add(e);
        return result;
    }

    public static Set<Employee> getByProject(Project project){
        Set<Employee> result = new HashSet<>();
        for(Employee e : employees){
            if (e != null) {
                for (Project p : e.getProjects())
                    if (p != null && p.getId() == project.getId()) {
                        result.add(e);
                        break;
                    }
            }
        }
        return result;
    }

    public static Set<Employee> getEmployees() {
        return employees;
    }

}
