package lesson30.home;

import java.util.HashSet;
import java.util.Set;

public class GeneralDAO <T> {

    private Set<T> items = new HashSet<T>();


    public T add(T t){
        if (t != null)
            items.add(t);
        return t;
    }

    public void remove(T t){
        items.remove(t);
    }

    public Set<T> getAll() {return items;}
}
