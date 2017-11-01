package lesson30.home;

import java.util.Collection;
import java.util.Date;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private Collection projects;

    public Employee(long id, String firstName, String lastName, Date dateHired, Position position, Department department, Collection projects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
        this.projects = projects;
    }

    public Employee(long id, String firstName, String lastName, Date dateHired, Position position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addProjects(Project project) {
        this.projects.add(project);
    }

    public void removeProject (Project project){
        projects.remove(project);
    }

    public Department getDepartment() {
        return department;
    }

    public Collection getProjects() {
        return projects;
    }
}

