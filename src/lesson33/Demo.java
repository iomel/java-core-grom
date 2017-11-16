package lesson33;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException{
        ReadWriteFile rwf = new ReadWriteFile();

        rwf.readFile("E:\\Test\\source\\new1.txt");
        rwf.writeFile("E:\\Test\\source\\new1.txt", "sdfgsdfg sfgsdfg new!");

    }
}
