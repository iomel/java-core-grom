package lesson8.accounts.arithmetic;

public class Arithmetic {
    public boolean check(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int el : array) {
            if (el < min)
                min = el;
            if (el > max)
                max = el;
        }

        return (max+min > 100) ? true : false;
    }
}
