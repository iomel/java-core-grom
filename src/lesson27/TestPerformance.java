package lesson27;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class TestPerformance {
    public static void main(String[] args) {

        testAddMethod();
        testRemoveMethod();
        testGetMethod();
    }

    private static void testAddMethod()
    {
        ArrayList<String> arrayList = new ArrayList<>();

        Date start = new Date();
        for (int i=0; i < 1_000_00; i++){
            arrayList.add(i, String.valueOf(i));
        }
        Date finish = new Date();

        long diff = finish.getTime() - start.getTime();
        System.out.println("add - array list : " + diff);

        LinkedList<String> linkedList =  new LinkedList<>();
        start = new Date();
        for (int i=0; i < 1_000_00; i++){
            linkedList.add(i, String.valueOf(i));
        }
        finish = new Date();

        diff = finish.getTime() - start.getTime();
        System.out.println("add - linked list : " + diff);
    }

    private static void testRemoveMethod()
    {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i=0; i < 1_000_00; i++){
            arrayList.add(i, String.valueOf(i));
        }
        Date start = new Date();
        for (int i=0; i < 90000; i++){
            arrayList.remove(10000);
        }
        Date finish = new Date();

        long diff = finish.getTime() - start.getTime();
        System.out.println("Remove - array list : " + diff);

        LinkedList<String> linkedList =  new LinkedList<>();
        for (int i=0; i < 1_000_00; i++){
            linkedList.add(i, String.valueOf(i));
        }

        start = new Date();
        for (int i=0; i < 90000; i++){
            linkedList.remove(10000);
        }
        finish = new Date();

        diff = finish.getTime() - start.getTime();
        System.out.println("Remove - linked list : " + diff);

    }

    private static void testGetMethod()
    {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i=0; i < 1_000_00; i++){
            arrayList.add(i, String.valueOf(i));
        }
        Date start = new Date();
        for (int i=0; i < 100000; i++){
            arrayList.get(50000);
        }
        Date finish = new Date();

        long diff = finish.getTime() - start.getTime();
        System.out.println("Get - array list : " + diff);

        LinkedList<String> linkedList =  new LinkedList<>();
        for (int i=0; i < 1_000_00; i++){
            linkedList.add(i, String.valueOf(i));
        }

        start = new Date();
        for (int i=0; i < 100000; i++){
            linkedList.get(50000);
        }
        finish = new Date();

        diff = finish.getTime() - start.getTime();
        System.out.println("Get - linked list : " + diff);

    }

}
