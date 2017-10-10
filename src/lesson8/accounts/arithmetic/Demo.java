package lesson8.accounts.arithmetic;

public class Demo {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 56, 13, 123};
        Adder adder = new Adder();

        System.out.println(adder.check(array));

        System.out.println(adder.add(array[1], array[3]));
    }
}
