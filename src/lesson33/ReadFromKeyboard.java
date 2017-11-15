package lesson33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromKeyboard {

    public static void main(String[] args) throws IOException{
        readKeyboardWithIOStream();
    }
    public static void readKeyboardWithIOStream() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your name:");
        String name = reader.readLine();
        if(isWord(name))
            System.out.println("Hello, " + name + "!");
        else
            System.out.println("Wrong word, try again!");

        reader.close();
    }

    private static boolean isWord (String word) {
        if (word != null && word.length()>2) {
            for (char ch : word.toCharArray())
                if (!Character.isLetter(ch))
                    return false;
            return true;
        }
        return false;
    }
}
