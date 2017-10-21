package lesson6;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        User user = new User("Vasya", 12, "Kiev", new Date(), true);

        user.increaseAge();
        user.logIn();
    }
}
