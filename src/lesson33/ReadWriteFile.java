package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {

    public void readFile(String path) throws FileNotFoundException {
        FileReader streamReader;
        try {
            streamReader = new FileReader(path);
        } catch (FileNotFoundException e){
            System.out.println("File not exist!");
            return;
        }
        BufferedReader reader = new BufferedReader(streamReader);
        String line;

        try {
            while ((line = reader.readLine()) !=null){
                System.out.println(line);
            }
        } catch(IOException e){
            System.err.println("Reading from file " +path+ " failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(streamReader);
        }
    }

    public void writeFile(String path, String content){
        FileWriter streamWriter = null;
        BufferedWriter writer = null;
        try {
            streamWriter = new FileWriter(path, true);
            writer = new BufferedWriter(streamWriter);
            writer.append("\n" + content);
        } catch(IOException e){
            System.err.println("Can't write to file");
        } finally {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(streamWriter);
        }
    }

}
