package lesson18.home;

public class Solution {
    public int[] findNumbers(String text)
    {
        if (text == null || text.isEmpty())
            return null;

        text = text.trim();
        String[] words = text.split(" ");
        int[] result = new int[words.length];
        int count = 0;
        for (String w : words)
        {
            w = w.trim();
            if (w.isEmpty())
                continue;
            try {
                result[count] = Integer.parseInt(w);
                count++;
            } catch (Exception e)
            {
                System.out.println("not a number");
            }
        }
        if (count == 0)
            return null;
        int[] finalResult = new int[count];
        for (int i =0; i < count; i++ )
            finalResult[i] = result[i];
        return finalResult;
    }
}
