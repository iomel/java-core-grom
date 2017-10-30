package lesson28.owncompare;

import java.util.*;

public class Demo {

    public static void main(String[] args) throws Exception{
        Capability capability1 = new Capability(1001, "test", "rrrr", false, new Date());
        Thread.sleep(1500);

        Capability capability4 = new Capability(910, null, "rrrr", false, new Date());
        Thread.sleep(1500);

        Capability capability5 = new Capability(1900, "test", null, true, new Date());
        Thread.sleep(1500);

        Capability capability6 = new Capability(700, "test", "rrrr", false, null);
        Thread.sleep(1500);

        Capability capability2 = new Capability(900, "test", "rrrr", false, new Date());
        Thread.sleep(1500);

        Capability capability7 = new Capability(901, "test", "rrr", false, new Date());
        Thread.sleep(1500);

        Capability capability3 = new Capability(1005, "test", "rrrr", true, new Date());


        Set<Capability> set = new TreeSet<>();
        set.add(capability1);
        set.add(capability2);
        set.add(capability3);
        set.add(capability4);
        set.add(capability5);
        set.add(capability6);


//        System.out.println(set);

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);
        capabilities.add(capability5);
        capabilities.add(capability6);
        capabilities.add(capability7);


//        capabilities.sort(new IsActiveComparator());
//        System.out.println(capabilities);
//
//        capabilities.sort(new DateComparator());
//        System.out.println(capabilities);

        capabilities.sort(new FullComparator());
        System.out.println(capabilities);

    }
}

