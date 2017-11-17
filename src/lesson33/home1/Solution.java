package lesson33.home1;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {

    public void writeToFileFromConsole(String path)
    {
        InputStreamReader console = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(console);
        String textToWrite = "";
        String input;
        boolean start = true;

        if (new File(path).exists()) {
            System.out.println("Enter file content to write in the file:");

            try {
                while (!(input = reader.readLine()).equals("wr")) {
                    if (start) {
                        textToWrite = textToWrite.concat(input);
                        start = false;
                    } else
                        textToWrite = textToWrite.concat("\n").concat(input);
                }
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

    private void writeFile(String path, String content){
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
