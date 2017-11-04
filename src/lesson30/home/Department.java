package lesson30.home;

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

    @Override
    public String toString() {
        return "Department{" + type + '}';
    }
}
