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

    public void writeToFileFromConsole(String path)
    {
        InputStreamReader console = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(console);
        String textToWrite = "";
        String input;

        if (new File(path).exists()) {
            System.out.println("Enter file content to write in the file:");

            try {
                while (!(input = reader.readLine()).equals("wr"))
                    textToWrite = textToWrite.concat(input);
            } catch (IOException e) {
                System.out.println("Can't read from console!");
            } finally {
                IOUtils.closeQuietly(reader);
                IOUtils.closeQuietly(console);
            }
            writeFile(path, textToWrite);
        } else
            System.out.println("File with path " + path + " not found");
    }


    public void readFileByConsolePath(){
        InputStreamReader console = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(console);
        String path = "";
        System.out.println("Please, enter file path to read:");

        try {
            path = reader.readLine();
        } catch (IOException e) {
            System.out.println("Can't read from console!");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(console);
        }
        readFile(path);
    }
}
