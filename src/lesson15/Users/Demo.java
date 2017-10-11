package lesson15.Users;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User[] users = {new User(1111, "Petya", "pppT"), null, null, null,new User(1121, null, null), new User(3333, "Vasya", "pppV"), };
        UserRepository uR = new UserRepository(users);

        System.out.println("1. " + uR.getUserNameById(1121));
        System.out.println("2. " + uR.getUserNameById(-1121));

        System.out.println("3. " + Arrays.toString(uR.getUserNames()));
        System.out.println("4. " + Arrays.toString(uR.getUserIds()));

        User testUser  = new User(1221, null, null);
        uR.save(testUser);
        System.out.println("5. " + Arrays.toString(uR.getUserNames()));

        for (int i = 0; i < 20; i++)
        {
            User addUs = new User(1229+i*12*i, "User-"+i, null);
            uR.save(addUs);
            System.out.println( Arrays.toString(uR.getUserNames()));

        }

        uR.update(new User(1221, null, "dfsd"));
        System.out.println("6. " + Arrays.toString(uR.getUserNames()));

        uR.delete(1111);
        System.out.println(Arrays.toString(uR.getUserNames()));

        uR.delete(0);
        System.out.println(Arrays.toString(uR.getUserNames()));


    }
}
