package Tasks.Arrays_test;

public class Solution {
    public boolean compareIntArrays(int[] first, int[] second) {
        if (first == second)
            return true;
        if (first == null || second == null)
            return false;

        if (first.length != second.length)
            return false;

        for (int i=0; i < first.length; i++)
            if(first[i] != second[i])
                return false;
        return true;
    }
    public boolean compareStringArrays(String[] first, String[] second){
        return compareArrays(first, second);
    }

    public <T> boolean compareArrays(T[] first, T[] second) {
        if (first == second)
            return true;
        if (first == null || second == null)
            return false;

        if (first.length != second.length)
            return false;

        for (int i=0; i < first.length; i++)
            if(!(first[i] == null ? second[i]==null : first[i].equals(second[i])))
                return false;
        return true;

    }
}
