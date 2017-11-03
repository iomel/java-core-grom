package lesson31;

public class Demo {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSymbols("sss dd fd www gg aa   .. .1 a").toString());
        System.out.println(solution.countSymbols("       ").toString());
        System.out.println(solution.countSymbols(null).toString());
        System.out.println(solution.countSymbols("       sds dd aa               a    ").toString());
        System.out.println(solution.countSymbols("").toString());

        System.out.println(solution.words(" dss    ss dss  sd s    ss ss  f 12wss      ").toString());
        System.out.println(solution.words("        dss  1  ss dss  sd s    ss ss  f 12wss      ").toString());
        System.out.println(solution.words(null).toString());
        System.out.println(solution.words("").toString());


    }
}
