package lesson30.home;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO extends GeneralDAO<Employee>{

    private static EmployeeDAO instance;

    private EmployeeDAO() {
    }

    public static EmployeeDAO getInstance() {
        if (instance == null)
            instance = new EmployeeDAO();
        return instance;
    }


    public Set<Employee> getByDepartment(DepartmentType depType){
        Set<Employee> result = new HashSet<>();
        for (Employee e : getAll())
            if (e != null && e.getDepartment().getType() == depType)
                result.add(e);
        return result;
    }

    public Set<Employee> getByProject(Project project){
        Set<Employee> result = new HashSet<>();
        for(Employee e : getAll()){
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

}
