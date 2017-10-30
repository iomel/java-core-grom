package Tasks;

import java.util.*;

public class Solution {
    public boolean compareIntArrays(int[] first, int[] second) {
        return compareArrays(wrap(first), wrap(second));

    }
    public boolean compareStringArrays(String[] first, String[] second){
        return compareArrays(first, second);
    }

    public <T> boolean compareArrays(T[] first, T[] second) {
        if (first == second)
            return true;
        if (first.length != second.length)
            return false;
        Arrays.sort(first);
        Arrays.sort(second);

        for (int i=0; i < first.length; i++)
            if (first[i] != second[i])
                return false;
        return true;
    }
    private Integer[] wrap(int[] array){
        Integer[] result = new Integer[array.length];
        for(int i=0; i < array.length; i++)
            result[i] = array[i];
        return result;
    }
}
