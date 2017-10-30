package lesson28.owncompare;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability>{

    @Override
    public int compare(Capability o1, Capability o2) {
        if(o1 == o2 && o1 == null)
            return 0;

        if (o1.getChannelName() != null && o2.getChannelName() != null && !o1.getChannelName().equals(o2.getChannelName()))
            return o1.getChannelName().compareTo(o2.getChannelName());
        else if ((o1.getChannelName() == null || o2.getChannelName() == null) && o1.getChannelName() != o2.getChannelName())
            return o1.getChannelName() == null ? 1 : -1;

        if (o1.getFingerprint() != null && o2.getFingerprint() != null && !o1.getFingerprint().equals(o2.getFingerprint()))
            return o1.getFingerprint().compareTo(o2.getFingerprint());
        else if ((o1.getFingerprint() == null || o2.getFingerprint() == null) && o1.getFingerprint() != o2.getFingerprint())
            return o1.getFingerprint() == null ? 1 : -1;

        if (o1.getDateCreated() != null && o2.getDateCreated() != null)
            return o1.getDateCreated().compareTo(o2.getDateCreated());
        else if ((o1.getDateCreated() == null || o2.getDateCreated() == null) && o1.getDateCreated() != o2.getDateCreated())
            return o1.getDateCreated() == null ? 1 : -1;

        return 0;
    }


}
