package lesson33.home2;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution1 {
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

    private void readFile(String path){
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

}
