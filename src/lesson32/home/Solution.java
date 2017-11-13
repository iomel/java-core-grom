package lesson32.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public int readNumbers () throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers;

        int count = 3;
        while (count != 0) {
            System.out.println("Please input string with 10 numbers:");
            numbers = whiteSpaceTrim(reader.readLine());
            if(isTenNumbers(numbers))
                return getSumm(numbers);

            System.out.println("Your numbers are wrong. " +
                    (--count > 0 ? "You have " + count + " attempts to try again" : "Number of attempts exceeded"));
        }
        return 0;
    }

    private boolean isTenNumbers(String[] numbers){
        if (numbers.length == 10){
            for (String number : numbers)
                if(!(isNumber(number) && Integer.parseInt(number)<=100))
                    return false;
            return true;
        }
        return false;
    }

    private boolean isNumber (String word) {
        if (word != null && !word.isEmpty() && word.length()<=3) {
            for (char ch : word.toCharArray())
                if (!Character.isDigit(ch))
                    return false;
            return true;
        }
        return false;
    }

    private String[] whiteSpaceTrim(String input){
        String[] numbers = null;
        if (!input.isEmpty() && input != null){
            while (input.contains("  "))
                input = input.replaceAll("  ", " ").trim();
            numbers = input.split(" ");
        }
        return numbers;
    }

    private int getSumm (String[] words) {
        int sum = 0;
        for (String num : words)
            sum += Integer.parseInt(num);
        return sum;
    }

}
