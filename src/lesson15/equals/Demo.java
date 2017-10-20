package lesson15.equals;

public class Demo {
    public static void main(String[] args) {
        File file1 = new File(111, "/task2/documents/test", "txt");
        File file2 = new File(111, "/task2/documents/image", "jpg");
        File file3 = new File(111, "/task2/documents/test", "txt");

        File someFile = file1;
        System.out.println(file1.equals(file2));
        System.out.println("-218737447");
        System.out.println("-218737447");
        System.out.println(file1.equals(file3));
        System.out.println(file1 == file3);

        System.out.println(file1 == someFile);

        User user = new User(123);
        System.out.println(file1.equals(user));
    }
}
