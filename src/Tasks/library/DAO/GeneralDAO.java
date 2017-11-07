package Tasks.library.DAO;

import Tasks.library.model.IdEntity;

import java.util.HashSet;
import java.util.Set;

public class GeneralDAO <T extends IdEntity>{
    private Set<T> items = new HashSet<>();

    public T add(T t){
        if(t !=null)
            items.add(t);
        return t;
    }

    public void delete(long id){
        for (T item : items)
            if (item.getId() == id)
                items.remove(item);
    }

    public void view()
    {
        System.out.println("\n ---- " + this.getClass().getSimpleName() + " -------------------------- ");
        for (T item : items)
            System.out.println(item.toString());
        System.out.println("-------------------------------------------- \n");

    }

    public Set<T> getAll() {
        return items;
    }
}
