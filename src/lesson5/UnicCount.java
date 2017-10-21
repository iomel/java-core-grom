package lesson5;

import java.util.Arrays;

public class UnicCount {

    public int uniqueCount(int[] array)
    {
        if (array.length == 1)
            return 1;

        int uniCount = 1;
        int temp;
        for (int i = 0; i < array.length; i++)
        {
            for(int j = i+1; j < array.length; j++)
            {
                if (array[i] > array[j])
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length-1; i++)
        {
            if(array[i] != array[i+1])
                uniCount++;
        }
        return uniCount;
    }
}
