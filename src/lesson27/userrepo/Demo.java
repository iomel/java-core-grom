package lesson27.userrepo;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1111, "Petya", "pppT"));
        users.add(null);
        User testUs = new User(5, "df", "testID");
        users.add(new User(3333, "Vasya", "pppV"));

        for (int i = 7; i < 50000; i++)
        {
            users.add(0, new User(i + 12, "Vasya" + i, "pppV"));

        }

        UserRepository uR = new UserRepository(users);

        uR.save(testUs);
        System.out.println(uR.getUserNameById(5));
        testUs.setName("Dasha");
        uR.update(testUs);
        System.out.println(uR.getUserNameById(5));

//        System.out.println(uR.getUserNames());
//        System.out.println(uR.getUserNames());
//
//        uR.delete(1111);
//        System.out.println(uR.getUserNames());
//
//        uR.delete(0);
//        System.out.println(uR.getUserNames());


    }
}
