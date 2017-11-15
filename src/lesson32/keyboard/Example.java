package lesson32.keyboard;

public class Example {
    // It was like this:
    private boolean isWord (String word) {
        if (word != null && word.length()>2 && !word.isEmpty() && word.split(" ").length == 1) {
            for (char ch : word.toCharArray())
                if (!Character.isLetter(ch) || Character.isWhitespace(ch))
                    return false;
            return true;
        }
        return false;
    }

    // Became:
    private boolean isWord (String word) {
        boolean isWord = true;

        if (word != null && word.length()>2) {
            for (char ch : word.toCharArray())
                if (!Character.isLetter(ch)) {
                    isWord = false;
                    break;
                }
        } else
            isWord = false;
        return isWord;
    }

    // Optima IMHO:

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
