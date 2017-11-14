package lesson32.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public int readNumbers () throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = null;
        int sum = 0;

        int count = 3;
        while (count != 0) {
            System.out.println("Please input string with 10 numbers:");
            numbers = validate(reader.readLine());
            if(numbers != null)
                break;

            System.out.println("Your numbers are wrong. " +
                    (--count > 0 ? "You have " + count + " attempts to try again" : "Number of attempts exceeded"));
        }

        if (numbers != null)
            for (String number : numbers)
                sum += Integer.parseInt(number);

        return sum;
    }

    private String[] validate (String input) {
        if (input == null || input.isEmpty())
            return null;

        while (input.contains("  "))
           input = input.replaceAll("  ", " ").trim();

        String[] numbers = input.split(" ").length == 10 ? input.split(" ") : null;

        if (numbers != null) {
            for (String number : numbers) {
                for (char ch : number.toCharArray())
                    if (!Character.isDigit(ch))
                        return null;
                if (Integer.parseInt(number) > 100)
                    return null;
            }
        }
        return numbers;
    }

}
