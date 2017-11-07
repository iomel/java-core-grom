package Tasks.Arrays_test;

public class ArrayDemo {

    public static void main(String[] args) {
        String[] first = {"we", "sdf", "sda", "aaa"};
        String[] second = {"wse", "1sdf", "sdaa", "2aaa"};
        Solution solution = new Solution();

        System.out.println(solution.compareStringArrays(first, second));

        int[] firstInt = {1, 34, 0, 14};
        int[] secondInt = {32,2,12,0,4};
        System.out.println(solution.compareIntArrays(firstInt, secondInt));

        int[] thirdInt = secondInt;
        System.out.println(solution.compareIntArrays(thirdInt, secondInt));


    }
}
