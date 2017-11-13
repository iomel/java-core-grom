package lesson32.keyboard;

import java.io.*;
import java.util.Scanner;

public class ReadFromKeyboard {

    public void readKeyboardWithScanner(){
        Scanner scanner = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("Please enter your name:");
            name = scanner.nextLine();
            if(isWord(name)){
                System.out.println("Hello, " + name + "!");
                break;
            } else
                System.out.println("Wrong word, try again!");
        }
    }

    public void readKeyboardWithIOStream() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while (true) {
            System.out.println("Please enter your name:");
            name = reader.readLine();
            if(isWord(name)){
                System.out.println("Hello, " + name + "!");
                break;
            } else
                System.out.println("Wrong word, try again!");
        }
        reader.close();
    }

    private boolean isWord (String word) {
        if (word != null && word.length()>2 && !word.isEmpty() && word.split(" ").length == 1) {
            for (char ch : word.toCharArray())
                if (!Character.isLetter(ch) || Character.isWhitespace(ch))
                    return false;
            return true;
        }
        return false;
    }

}
