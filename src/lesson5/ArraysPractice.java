package lesson5;

public class ArraysPractice {

    public int maxElement(int[] array)
    {
        int max = array[0];

        for (int el : array)
            if (el > max)
                max = el;

        return max;
    }

    public int nCount(int[] array, int n) {
        int count = 0;

        for (int el : array)
            if (el == n)
                count++;

        return count;
    }

}
