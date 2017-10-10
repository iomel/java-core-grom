package lesson4;

public class StringTest {
    public boolean compareSums(int a, int b, int c, int d)
    {
        return (sum(a,b)>sum(c,d));
    }

    public long sum(int from, int to)
    {
        long sum = 0;
        for (int i = from; i <= to; i++)
            sum += i;
        return sum;
    }
}
