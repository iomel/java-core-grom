package lesson30.home;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private Set<Project> projects = new HashSet<>();

    public Employee(long id, String firstName, String lastName, Date dateHired, Position position, Department department, Set<Project> projects) {
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
        if (department != null)
            this.department = department;
    }

    public void addProject(Project project) {
        if (project != null)
            this.projects.add(project);
    }

    public void removeProject (Project project){
        projects.remove(project);
    }

    public Department getDepartment() {
        return department;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "\n Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", department=" + department +
                '}';
    }
}

