package lesson32.home;


import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println("Summ is: " + solution.readNumbers());


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

}
