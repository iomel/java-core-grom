package lesson5;

public class SortArray {

    public int[] sortAscending(int[] array)
    {
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
        return array;
    }

    public int[] sortDescending(int[] array)
    {
        int temp;
        for (int i = 0; i < array.length; i++)
        {
            for(int j = i+1; j < array.length; j++)
            {
                if (array[i] < array[j])
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }
}
