package lesson31;

import java.util.TreeMap;

public class Solution {

    public TreeMap<Character, Integer> countSymbols(String text){
        TreeMap<Character, Integer> letterMap = new TreeMap<>();

        if (text != null) {
            for (char ch : text.toCharArray())
                if (Character.isLetter(ch))
                    letterMap.compute(ch, (key, oldVal) -> oldVal == null ? 1 : oldVal + 1) ;
        }
        return letterMap;
    }

    public TreeMap<String, Integer> words(String text){
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        if (text != null && !text.isEmpty()) {
            String[] words = text.replaceAll(" +", " ").trim().split(" ");
            for (String word : words)
                if(isWord(word))
                    wordMap.compute(word, (key, oldVal) -> oldVal == null ? 1 : oldVal + 1) ;
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
