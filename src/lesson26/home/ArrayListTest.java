package lesson26.home;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    public List<Order> useList (){
        ArrayList<Order> list = new ArrayList<>();

        list.clear();
        for (int i = 0; i < 10; i++){
            list.add(new Order(i, 12*i, "USD", "Item # " + i, "ID :" + i*11));
        }

        Order ord1 = new Order(99, 100500, "KZT", "Pahlava", "Vkysnyi da!");
        list.add(5, ord1);
        list.remove(0);
        list.remove(ord1);

        ArrayList<Order> list1 = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            list.add(new Order(i*5, 21*i, "EUR", "S_Item # " + i, "ID :" + i*21));
        }

        list.addAll(list1);
        list.set(5, ord1);

        if (list.contains(ord1)){
            list1.toArray();
        }

        return list.subList(0,5);
    }

}
