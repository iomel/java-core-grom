package lesson8.accounts.students;

public class SpecialStudent extends CollegeStudent {
    public long secretKey;
    public String email;

    public SpecialStudent(String firstName, String lastName, int group, Course[] coursesTaken, long secretKey, String email) {
        super(firstName, lastName, group, coursesTaken);
        this.secretKey = secretKey;
        this.email = email;
    }
}
