package lesson32.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public int readNumbers () throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        int count = 3;
        while (count != 0) {
            System.out.println("Please input string with 10 numbers:");
            String[] numbers = validate(reader.readLine());
            if(numbers != null) {
                for (String number : numbers)
                    sum += Integer.parseInt(number);
                return sum;
            }
            System.out.println("Your numbers are wrong. " +
                (--count > 0 ? "You have " + count + " attempts to try again" : "Number of attempts exceeded"));
        }
        return sum;
    }

    private String[] validate (String input) {
        String[] numbers = input.split(" ");

        if (numbers.length == 10)
            for (String number : numbers)
                if (!(isRightNumber(number) && Integer.parseInt(number) <= 100))
                    return null;
        return numbers.length != 10 ? null : numbers;
    }

    private boolean isRightNumber (String number){
        for (char ch : number.toCharArray())
            if (!Character.isDigit(ch))
                return false;
        return true;
    }
}
