package lesson32.keyboard;

import java.io.*;
import java.util.Scanner;

public class ReadFromKeyboard {

    public void readKeyboardWithScanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        if(isWord(name))
           System.out.println("Hello, " + name + "!");
        else
           System.out.println("Wrong word, try again!");
    }

    public void readKeyboardWithIOStream() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your name:");
        String name = reader.readLine();
        if(isWord(name))
            System.out.println("Hello, " + name + "!");
        else
            System.out.println("Wrong word, try again!");

        reader.close();
    }

    private boolean isWord (String word) {
        if (word != null && word.length()>2) {
            for (char ch : word.toCharArray())
                if (!Character.isLetter(ch))
                    return false;
            return true;
        }
        return false;
    }
}
