package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {

    public void readFile(String path){
        FileReader streamReader;
        try {
            streamReader = new FileReader(path);
        } catch (FileNotFoundException e){
            System.out.println("File with path " + path + " not found");
            return;
        }
        BufferedReader reader = new BufferedReader(streamReader);
        String line;

        try {
            while ((line = reader.readLine()) !=null){
                System.out.println(line);
            }
        } catch(IOException e){
            System.err.println("Can't read file by path " + path);
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
            writer.append(content);
        } catch(IOException e){
            System.err.println("Can't write to file with path " + path);
        } finally {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(streamWriter);
        }
    }
}
