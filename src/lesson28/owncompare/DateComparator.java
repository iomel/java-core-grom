package lesson28.owncompare;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if(o1 == o2 && o1 == null)
            return 0;
        if (o2.getDateCreated() == null)
            return -1;
        if (o1.getDateCreated() == null)
            return 1;
        return o2.getDateCreated().compareTo(o1.getDateCreated());
    }
}
