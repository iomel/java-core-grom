package lesson8.accounts.students;

import java.util.Date;

public class Course {
    public Date startDate;
    public String name;
    public int hoursDuration;
    public String teacherName;
    public Student[] students;

    public Course(Date startDate, String name, int hoursDuration, String teacherName, Student[] students) {
        this.startDate = startDate;
        this.name = name;
        this.hoursDuration = hoursDuration;
        this.teacherName = teacherName;
        this.students = students;
    }
}
