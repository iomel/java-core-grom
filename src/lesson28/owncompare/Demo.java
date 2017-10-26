package lesson28.owncompare;

import java.util.*;

public class Demo {

    public static void main(String[] args) throws Exception{
        Capability capability1 = new Capability(1001, "test", "rrrr", false, new Date());
        Thread.sleep(5000);

        Capability capability2 = new Capability(900, "test", "rrrr", false, new Date());
        Thread.sleep(5000);

        Capability capability3 = new Capability(1005, "test", "rrrr", true, new Date());

        Set<Capability> set = new TreeSet<>();
        set.add(capability1);
        set.add(capability2);
        set.add(capability3);

        System.out.println(set);

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);

        capabilities.sort(new IsActiveComparator());
        System.out.println(capabilities);

        capabilities.sort(new DateComparator());
        System.out.println(capabilities);

        capabilities.sort(new FullComparator());
        System.out.println(capabilities);

    }
}

