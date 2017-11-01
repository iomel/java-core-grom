package lesson30.home;

import java.util.HashSet;
import java.util.Set;

public class ProjectDAO {

    private static Set<Project> projects = new HashSet<>();

    public static Project add(Project project){
        if (project != null)
            projects.add(project);
        return project;
    }

    public static void remove(Project project){
        projects.remove(project);
    }

    public static Project getById (long id) {
        for (Project p : projects)
            if (p != null && p.getId() == id)
                return p;
        return null;
    }

    public static Project get(Project project){
        return getById(project.getId());
    }

    public static Set<Project> getProjects() {
        return projects;
    }
}
