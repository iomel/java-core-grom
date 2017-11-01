package lesson30.home;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Department {
    private DepartmentType type;
    private Set<Employee> employees = new HashSet<>();

    public Department(DepartmentType type) {
        this.type = type;
    }

    public DepartmentType getType() {
        return type;
    }

    public Collection getEmployees() {
        return employees;
    }

    public Employee addEmployee (Employee e){
        if (e != null)
            employees.add(e);
        e.setDepartment(this);
        return e;
    }

    public Employee getEmployeeById (long id) {
        for (Employee e : employees)
            if(e.getId() == id)
                return e;
        return null;
    }
}
