package lesson33;

import java.io.FileNotFoundException;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException{
        ReadWriteFile rwf = new ReadWriteFile();

//        rwf.readFile("E:\\Test\\source\\new1.txt");
//        rwf.writeFile("E:\\Test\\source\\new1.txt", "sdfgsdfg sfgsdfg new!");
//        rwf.writeToFileFromConsole("E:\\Test\\source\\new11.txt");
//        rwf.writeToFileFromConsole("E:\\Test\\source\\new1.txt");

            rwf.readFileByConsolePath();
    }
}
