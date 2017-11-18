package lesson34.task1;

import java.io.*;

public class Solution {
    public  void copyFileContent(String fileFromPath, String fileToPath) throws Exception{

        validate(fileFromPath, fileToPath);

        StringBuffer content = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(fileFromPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileToPath,true))){
            String line;
            while ((line = br.readLine()) != null)
                content = content.append("\n").append(line);
            bw.append(new StringBuffer(content.substring(1)));
        } catch (FileNotFoundException e){
            System.err.println("File not found!");
        } catch (IOException e){
            System.err.println(e.getMessage());
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
