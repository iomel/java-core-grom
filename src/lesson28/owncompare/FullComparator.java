package lesson28.owncompare;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability>{

    @Override
    public int compare(Capability o1, Capability o2) {
        if(o1 == o2 && o1 == null)
            return 0;

        if (nameCheck(o1, o2) != 0)
            return nameCheck(o1, o2);

        if (fingerprintCheck(o1, o2) !=0)
            return fingerprintCheck(o1, o2);

       return dateCheck(o1, o2);
    }

    private int  fingerprintCheck(Capability o1, Capability o2){
        if (o1.getFingerprint() == null)
            return 1;
        else if (o2.getFingerprint() == null)
            return -1;
        else
            return o1.getFingerprint().compareTo(o2.getFingerprint());
    }

    private int  dateCheck(Capability o1, Capability o2){
        if (o1.getDateCreated() == null)
            return 1;
        else if (o2.getDateCreated() == null)
            return -1;
        else
            return o1.getDateCreated().compareTo(o2.getDateCreated());
    }

    private int  nameCheck(Capability o1, Capability o2){
        if (o1.getChannelName() == null)
            return 1;
        else if (o2.getChannelName() == null)
            return -1;
        else
            return o1.getChannelName().compareTo(o2.getChannelName());
    }




}
