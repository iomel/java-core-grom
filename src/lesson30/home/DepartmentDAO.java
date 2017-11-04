package lesson30.home;


public class DepartmentDAO extends GeneralDAO<Department> {
    private static DepartmentDAO instance;


    private DepartmentDAO() {
        for (DepartmentType d : DepartmentType.values())
            getAll().add(new Department(d));
    }

    public static DepartmentDAO getInstance() {
        if (instance == null)
            instance = new DepartmentDAO();
        return instance;
    }

    public Department getDepartmentByType(DepartmentType type){
        for (Department dep : getAll())
            if (dep.getType() == type)
                return dep;
        return null;
    }

}
