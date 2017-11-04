package lesson30.home;


public class DepartmentDAO extends GeneralDAO<Department> {

    public DepartmentDAO() {
        for (DepartmentType d : DepartmentType.values())
            getAll().add(new Department(d));
    }

    public Department getDepartmentByType(DepartmentType type){
        for (Department dep : getAll())
            if (dep.getType() == type)
                return dep;
        return null;
    }

}
