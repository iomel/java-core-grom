package lesson19.home;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) {

        File file1 = new File(1234, "testText", "txt", 25);
        File file2 = new File(1274, "justText", "txt", 15);
        File file3 = new File(1934, "picture", "jpg", 45);
        File file4 = new File(1294, "wordFile", "doc", 35);
        File file5 = new File(9234, "movie", "avi", 250);
        File file6 = new File(9134, "movie2", "avi", 260);
        File file7 = new File(3134, "audio", "mp3", 110);

        File[] smallFiles = {file1, file2, file3, file4};
        File[] largeFiles = {file5, file6, file7};
        File[] oneFiles = {file7};


        String[] smallFormats = {"txt", "jpg", "doc"};
        String[] largeFormats = {"avi", "mp3"};
        String[] allFormats = {"txt", "jpg", "doc", "avi", "mp3"};

        Storage smallStorage = new Storage(1298, smallFiles,smallFormats, "UA", 200);
        Storage largeStorage = new Storage(1238, largeFiles,largeFormats, "UA", 700);
        Storage allStorage = new Storage(9298, oneFiles,allFormats, "UA", 700);

        Controller controller = new Controller();

        File longFileName = new File(8273,"bookershtrasse van der gemakkileg", "txt", 12);

        // put TEST1 - put large file
        try {
            controller.put(smallStorage, file4);
            smallStorage.printStorage();

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        // put TEST2 put normal file
        try {
            controller.put(smallStorage, new File(8273,"book", "txt", 12));
            smallStorage.printStorage();

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        // put TEST3 put file with long name
        try {
            controller.put(smallStorage, longFileName);
            smallStorage.printStorage();

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        // put TEST4 put null file
        try {
            controller.put(smallStorage, null);
            smallStorage.printStorage();

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        // delete TEST1 del null file
        try {
            controller.delete(smallStorage, null);
            smallStorage.printStorage();

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        // delete TEST2 del null file
        try {
            controller.delete(smallStorage, file1);
            smallStorage.printStorage();

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        // transferAll TEST1 smallStor to allStor
        try {
            controller.transferAll(smallStorage, allStorage);
            allStorage.printStorage();

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        // transferFile TEST1 file6 to allStor
        try {
            controller.transferFile(largeStorage, allStorage, 9134);
            allStorage.printStorage();

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
