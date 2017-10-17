package lesson19.home;


import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        // TEST Files
        File file1 = new File(1234, "testText", "txt", 25);
        File file2 = new File(1274, "justText", "txt", 15);
        File file3 = new File(1934, "picture", "jpg", 45);
        File file4 = new File(1294, "wordFile", "doc", 35);
        File file5 = new File(9234, "movie", "avi", 250);
        File file6 = new File(9134, "movie2", "avi", 260);
        File file7 = new File(3134, "audio", "mp3", 110);
        File longFileName = new File(8273,"bookershtrasse van der gemakkileg", "txt", 12);

        // TEST file sets
        File[] smallFiles = {file1, file2, file3, file4};
        File[] smallFiles2 = {file5, file7, file3, file4};
        File[] largeFiles = {file5, file6, file7};
        File[] oneFiles = {file7};
//        File[] emptyStor = null;

        // TEST file formats
        String[] smallFormats = {"txt", "jpg", "doc"};
        String[] largeFormats = {"avi", "mp3"};
        String[] allFormats = {"txt", "jpg", "doc", "avi", "mp3"};

        // CONTROLLER
        Controller controller = new Controller();

        // TEST storages
        Storage smallStorage = new Storage(1298, smallFiles, smallFormats, "UA", 200);
        Storage smallStorage2 = new Storage(1498, smallFiles2, allFormats, "UA", 200);
        Storage emptyStorage = new Storage(1798, null, allFormats, "UA", 200);
        Storage largeStorage = new Storage(1238, largeFiles,largeFormats, "UA", 700);
        Storage allStorage = new Storage(9298, oneFiles,allFormats, "UA", 700);


        // put TEST1 - put large file
        try {
            System.out.println("TEST 1 : ");
            System.out.println(controller.put(smallStorage, file6));
            smallStorage.printStorage();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // put TEST2 put normal file
        try {
            System.out.println("TEST 2 : ");
            System.out.println(controller.put(smallStorage, new File(8273,"book", "txt", 12)));
            smallStorage.printStorage();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // put TEST3 put file with long name
        try {
            System.out.println("TEST 3 : ");
            System.out.println(controller.put(smallStorage, longFileName));

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // put TEST4 put null file
        try {
            System.out.println("TEST 4 : ");
            System.out.println(controller.put(smallStorage, null));

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // put TEST5 put file with wrong format
        try {
            System.out.println("TEST 5 : ");
            System.out.println(controller.put(smallStorage, new File(12294, "wordFile", "docs", 35)));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // put TEST6 put file with empty format
        try {
            System.out.println("TEST 6 : ");
            System.out.println(controller.put(smallStorage, new File(12944, "wordFile", "", 35)));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // put TEST6.1 put file with empty name
        try {
            System.out.println("TEST 6.1 : ");
            System.out.println(controller.put(smallStorage, new File(12394, "", "txt", 35)));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // put TEST6.2 put file to empty storage
        try {
            System.out.println("TEST 6.2 : ");
            emptyStorage.printStorage();

            System.out.println(controller.put(emptyStorage, file3));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        // put TEST7 put file with null filename
        try {
            System.out.println("TEST 7 : ");
            System.out.println(controller.put(smallStorage, new File(124394, null, "doc", 3)));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // put TEST8 put file with null format
        try {
            System.out.println("TEST 8 : ");
            System.out.println(controller.put(smallStorage, new File(12194, "word2", null, 3)));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


        // delete TEST1 del null file
        try {
            System.out.println("Delete TEST 1 ");
            controller.delete(smallStorage, null);
            smallStorage.printStorage();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // delete TEST2 del file
        try {
            System.out.println("Delete TEST 2 ");
            smallStorage.printStorage();

            controller.delete(smallStorage, file1);
            smallStorage.printStorage();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // delete TEST3 del large name file
        try {
            System.out.println("Delete TEST 3 ");
            controller.delete(smallStorage, longFileName);
            smallStorage.printStorage();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        // transferAll TEST1 smallStor to allStor
        try {
            controller.transferAll(smallStorage, allStorage);
            smallStorage.printStorage();
            allStorage.printStorage();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // transferAll TEST2 smallStor to allStor
        try {
            System.out.println("transferAll TEST2 smallStor2 to allStor");
            smallStorage2.printStorage();
            allStorage.printStorage();
            controller.transferAll(smallStorage2, allStorage);
            allStorage.printStorage();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


        // transferAll TEST3 emptyStorage to allStor
        try {
            System.out.println("transferAll TEST3 emptyStor to allStor");

            controller.delete(allStorage, file5);
            controller.delete(emptyStorage, file3);
            System.out.println(Arrays.toString(emptyStorage.getFiles()));
            System.out.println(emptyStorage.getFiles().length);
            emptyStorage.printStorage();
            allStorage.printStorage();
            controller.transferAll(emptyStorage, allStorage);

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        // transferFile TEST1 file6 to allStor
        try {
            controller.transferFile(largeStorage, allStorage, 9134);
            allStorage.printStorage();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
