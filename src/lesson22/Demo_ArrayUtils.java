package lesson22;

import java.util.Arrays;

public class Demo_ArrayUtils {
    public static void main(String[] args) {
        int[] array = {23, 4, 6, -32, 0, 4, 3, 6, 4};

        System.out.println(ArrayUtils.maxElement(array));
        System.out.println(ArrayUtils.nCount(array, 2));
        System.out.println(Arrays.toString(ArrayUtils.sortAscending(array)));
        System.out.println(Arrays.toString(ArrayUtils.sortDescending(array)));

    }
}
