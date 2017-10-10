package lesson8.accounts.students;

import java.util.Date;

public class Demo {

    public static Student createHighestParent()
    {

        Course cur = new Course(new Date(), "Math", 20, "Petrovich", null);
        Course[] curList = {cur};
        return new Student("Vasya", "Pupkin", 312, curList);
    }

    public static SpecialStudent createLowestChild ()
    {
        Course cur = new Course(new Date(), "Math", 20, "Petrovich", null);
        Course[] curList = {cur};

        return new SpecialStudent("Ferdya", "Lozhkin", 313, curList, 222333222, "specstud@gmail.com");
    }
}
