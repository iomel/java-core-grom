package lesson34.commons;


public class Demo {

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
//        solution.copyFileContent("E:\\Test\\test\\new2.txt", "E:\\Test\\test\\result.txt");
        solution.copyFileContentApacheIO("E:\\Test\\test\\result.txt", "E:\\Test\\test\\new2.txt");

    }

}
