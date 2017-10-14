package lesson18.home;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.findNumbers("")));
        System.out.println(Arrays.toString(solution.findNumbers(null)));
        System.out.println(Arrays.toString(solution.findNumbers("    ")));
        System.out.println(Arrays.toString(solution.findNumbers("   ddsf sdf dfhfh    dfg3fg 22")));
        System.out.println(Arrays.toString(solution.findNumbers("   221 d   sdf 23 45464 4      /")));


    }
}
