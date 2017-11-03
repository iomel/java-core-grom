package lesson32;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Summ is: " + stringInput());

    }

    public static int stringInput (){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int count = 3;

        while (count != 0) {

            System.out.println("Please input string with 10 numbers:");
            try {
                input = reader.readLine();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            String[] numbers = checkString(input);
            if (numbers == null){
                count--;
                System.out.println("Wrong input! You have " + (count > 1 ? count : "no") + " attempts left!" ) ;
                continue;
            } else
                return getSumm(numbers);
        }
        System.out.println("Sorry, you have used all attempts...");
        return 0;
    }

    private static String[] checkString(String input){

        if (input.isEmpty() || input == null)
            return null;

        while (input.contains("  "))
            input = input.replaceAll("  ", " ");

        String[] numbers = input.trim().split(" ");

        if (numbers.length != 10)
            return null;

        for (String number : numbers) {
            if (number.length() <= 3){
                for (char ch : number.toCharArray())
                    if (!Character.isDigit(ch))
                        return null;
            } else
                return null;
        }

        return numbers;
    }

    private static int getSumm (String[] words)
    {
        int sum = 0;
        for (String num : words) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
