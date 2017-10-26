package lesson27.userrepo;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1111, "Petya", "pppT"));
        users.add(null);
        users.add(new User(1121, null, null));
        users.add(new User(3333, "Vasya", "pppV"));
        UserRepository uR = new UserRepository(users);

        System.out.println(uR.getUserNameById(1121));
        System.out.println(uR.getUserNameById(-1121));

        System.out.println(uR.getUserNames());
        System.out.println(uR.getUserNames());

        uR.delete(1111);
        System.out.println(uR.getUserNames());

        uR.delete(0);
        System.out.println(uR.getUserNames());


    }
}
