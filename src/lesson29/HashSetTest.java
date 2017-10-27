package lesson29;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public Set<Order> useHashSet(){
        Set<Order> set = new HashSet<>();

        for (int i = 0; i < 10; i++)
            set.add(new Order(i*172L, 212,"USD", "Item " + i, "ID: " + i*12));

        Order order =  new Order(11, 21, "EUR", "Item__11", "ID - 123");
        set.add(order);
        set.remove(order);
        set.toArray();

        Set<Order> set2 = new HashSet<>();
        set.retainAll(set2);


        set.clear();
        for (int i = 0; i < 5; i++)
            set.add(new Order(i*172L, 212,"USD", "Item " + i, "ID: " + i*12));

        return set;
    }
}
