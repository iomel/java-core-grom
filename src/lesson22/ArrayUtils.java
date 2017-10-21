package lesson22;

public class ArrayUtils {

    public static int maxElement(int[] array)
    {
        int max = array[0];
        for (int el : array)
            if (el > max)
                max = el;
        return max;
    }

    public static int nCount(int[] array, int n) {
        int count = 0;
        for (int el : array)
            if (el == n)
                count++;
        return count;
    }

    public static int[] sortAscending(int[] array)
    {
        int temp;
        for (int i = 0; i < array.length; i++)
            for(int j = i+1; j < array.length; j++)
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
        return array;
    }

    public static int[] sortDescending(int[] array)
    {
        int temp;
        for (int i = 0; i < array.length; i++)
            for(int j = i+1; j < array.length; j++)
                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
        return array;
    }

}
