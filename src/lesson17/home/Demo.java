package lesson17.home;

public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String testInput = "dfgdfg dfgdg   dfgg sdfs  345 %^&sd";
/*        System.out.println(solution.minWord(testInput));
        System.out.println(solution.minWord(""));
        System.out.println(solution.minWord("     "));
        System.out.println(solution.minWord(" sdg&"));
        System.out.println(solution.minWord(" sdg"));
        System.out.println(solution.minWord(" sdg& "));


        String testInput1 = "dfgdfg аыва   dfgg sdfs  345 %^&sd";
        System.out.println(solution.countWords(testInput1));

        System.out.println(solution.countWords("    "));
        System.out.println(solution.countWords(null));

        solution.maxWord(testInput);
        solution.minWord(testInput);
        */
/*
        System.out.println(solution.mostCountedWord("ppp ss ppp ss ss dssdf ppp ss gfdg ppp"));
        System.out.println(solution.mostCountedWord(" ppp2 ss ppp dssdf ppp ss ss gfdg ppp"));
        System.out.println(solution.mostCountedWord(" ppp ss   ppp dssdf  gfdg sppp"));
        System.out.println(solution.mostCountedWord(""));
        System.out.println(solution.mostCountedWord("      "));

        System.out.println(solution.mostCountedWord(null));
        System.out.println(solution.mostCountedWord(" dd   dd"));
        System.out.println(solution.mostCountedWord(" d$d   d$d"));
        System.out.println(solution.mostCountedWord(" dd d$d"));
*/
        System.out.println(solution.validate(""));
        System.out.println(solution.validate(null));
        System.out.println(solution.validate("http:// "));
        System.out.println(solution.validate("https://.sdf.ss.fd"));

        System.out.println(solution.validate("http://www.ssdfgs.com"));
        System.out.println(solution.validate("http://ssdfgs.com"));

        System.out.println(solution.validate("http://www.sdf.ss.com"));
        System.out.println(solution.validate("http://www.sd%f.ss.com"));

    }
}
