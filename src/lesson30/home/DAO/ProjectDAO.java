package lesson30.home.DAO;

import lesson30.home.Project;

import java.util.HashSet;
import java.util.Set;

public class ProjectDAO {

    private static Set<Project> projects = new HashSet<>();

    public static Project add(Project project){
        projects.add(project);
        return project;
    }

    public static void remove(Project project){
        projects.remove(project);
    }

    public static Project getById (long id) {


        return null;
    }

    public static Set<Project> getProjects() {
        return projects;
    }
}
