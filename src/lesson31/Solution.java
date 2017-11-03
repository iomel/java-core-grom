package lesson31;

import java.util.TreeMap;

public class Solution {

    public TreeMap<Character, Integer> countSymbols(String text){
        TreeMap<Character, Integer> letterMap = new TreeMap<>();
        if (text != null) {
            for (char ch : text.toCharArray())
                if (Character.isLetter(ch)) {
                    if (!letterMap.containsKey(ch))
                        letterMap.put(ch, 1);
                    else
                        letterMap.put(ch, letterMap.get(ch) + 1);
                }
        }
        return letterMap;
    }

    public TreeMap<String, Integer> words(String text){
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        if (text != null && !text.isEmpty()) {
            while (text.contains("  "))
                text = text.replaceAll("  ", " ");

            String[] words = text.trim().split(" ");
            for (String word : words)
                if(isWord(word)) {
                    if (!wordMap.containsKey(word))
                        wordMap.put(word, 1);
                    else
                        wordMap.put(word, wordMap.get(word) + 1);
                }
        }
        return wordMap;
    }

    private boolean isWord (String word) {
        if (word.length()<2)
            return false;
        for (char ch : word.toCharArray())
            if (!Character.isLetter(ch))
                return false;
        return true;
    }
}
