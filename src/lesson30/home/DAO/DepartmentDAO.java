package lesson30.home.DAO;


import lesson30.home.Department;
import lesson30.home.enams.DepartmentType;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {

    {init();}

    private static Set<Department> departments = new HashSet<>();


    public static Set<Department> getDepartments() {
        return departments;
    }

    public static Department add (Department dep){
        departments.add(dep);
        return dep;
    }

    public static void remove (Department dep){
        departments.remove(dep);
    }


    public static Department getDepartmentByType(DepartmentType type){
        for (Department dep : departments)
            if (dep.getType() == type)
                return dep;
        return null;
    }

    private static void init(){
        for (DepartmentType d : DepartmentType.values())
            departments.add(new Department(d));
    }
}
