package lesson25.home;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO<String> strArray = new GeneralDAO<>();
        strArray.save("one");
        strArray.save("two");
        strArray.save("three");
        System.out.println(Arrays.deepToString(strArray.getAll()));

        GeneralDAO<Integer> intArray = new GeneralDAO<>();
        intArray.save(11);
        intArray.save(22);
        intArray.save(33);
        System.out.println(Arrays.deepToString(intArray.getAll()));

        GeneralDAO<TestClass> testArray = new GeneralDAO<>();
        for (int i = 0; i < 5 ; i++){
            testArray.save(new TestClass("test" + i, "test class number" + i));
        }
        System.out.println(Arrays.deepToString(testArray.getAll()));

    }
}
