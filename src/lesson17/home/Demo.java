package lesson17.home;

public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String testInput = "dfgdfg dfgdg   dfgg sdfs  345 %^&sd";
        System.out.println(solution.maxWord(testInput));
        System.out.println(solution.maxWord(""));
        System.out.println(solution.maxWord("     "));
        System.out.println(solution.maxWord(" sdg&"));
        System.out.println(solution.maxWord(" sdg"));
        System.out.println(solution.maxWord(" sdg& "));


        String testInput1 = "dfgdfg аыва   dfgg sdfs  345 %^&sd";
        System.out.println(solution.countWords(testInput1));

        System.out.println(solution.countWords("    "));
        System.out.println(solution.countWords(null));

        solution.maxWord(testInput);
        solution.minWord(testInput);

        System.out.println(solution.mostCountedWord("ppp ss ppp dssdf ppp ss ss gfdg ppp"));

        System.out.println(solution.validate("htt://sdf.ss"));
        System.out.println(solution.validate("https://sdf.ss.com"));
        System.out.println(solution.validate("https://.sdf.ss.fd"));
        System.out.println(solution.validate("http://www.sdf.ss.com"));
        System.out.println(solution.validate("http://www.sd%f.ss.com"));

    }
}
