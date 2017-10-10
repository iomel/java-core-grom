package lesson14;

import java.io.IOException;

public class Test implements Cloneable {

    private int someNumber;
    private String name;

    public Test(int someNumber, String name) {
        this.someNumber = someNumber;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test(1000, "name");
        System.out.println(test);

        Test test1 = (Test) test.clone();
        System.out.println(test1);
        System.out.println(test1.hashCode());

        Test test2 = new Test(test.someNumber, test.getName());
    }

    @Override
    public String toString() {
        return "Test{" +
                "someNumber=" + someNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public int getSomeNumber() {
        return someNumber;
    }

    public String getName() {
        return name;
    }
}
