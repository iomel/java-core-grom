package lesson34.task1;

import java.io.*;

public class Solution {
    public  void copyFileContent(String fileFromPath, String fileToPath) throws Exception{

        validate(fileFromPath, fileToPath);

        writeFile(fileToPath, readFile(fileFromPath));

    }

    private StringBuffer readFile(String path) throws Exception{
        StringBuffer content = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null)
                content = content.append("\n").append(line);
            content = new StringBuffer(content.substring(1));
        } catch (IOException e){
            throw new IOException("Can't read file " + path);
        }
        return content;
    }

    private void writeFile(String path, StringBuffer content) throws Exception{
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
            bw.append(content);
        } catch (IOException e){
            throw new IOException("Can't write file " + path);
        }
    }

    private void validate(String fileFromPath, String fileToPath) throws Exception{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileFrom.exists())
            throw new FileNotFoundException("File " + fileFrom + "does not exist");
        if (!fileTo.exists())
            throw new FileNotFoundException("File " + fileTo + "does not exist");
        if (!fileFrom.canRead())
            throw new Exception("Can't read file" + fileFrom);
        if (!fileTo.canWrite())
            throw new Exception("Can't write to file" + fileTo);
    }
}
