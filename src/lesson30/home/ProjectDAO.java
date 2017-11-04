package lesson30.home;

public class ProjectDAO extends GeneralDAO<Project>{

    private static ProjectDAO instance;

    private ProjectDAO() {
    }

    public static ProjectDAO getInstance() {
        if (instance == null)
            instance = new ProjectDAO();
        return instance;
    }

}
