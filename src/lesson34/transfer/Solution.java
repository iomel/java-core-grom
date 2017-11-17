package lesson34.transfer;

import java.io.*;

public class Solution {
    public void transferFileContent(String fileFromPath, String fileToPath) throws Exception{
        validate(fileFromPath, fileToPath);

        String content = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileFromPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileToPath,true))){

            while (br.ready())
                content = content.concat("\n").concat(br.readLine());
            content = (new File(fileToPath).length() == 0) ? content.substring(1) : content;
            bw.append(content);
            bw.flush();
        } catch (FileNotFoundException e){
            System.err.println("File not found!");
        } catch (IOException e){
            System.err.println(e.getMessage());
        }

        try (  BufferedWriter fileToClear = new BufferedWriter(new FileWriter(fileFromPath))){
            fileToClear.write("");
        } catch (FileNotFoundException e){
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
        if (!fileFrom.canRead() || !fileFrom.canWrite())
            throw new Exception("Can't read\\clear file" + fileFrom);
        if (!fileTo.canWrite())
            throw new Exception("Can't write to file" + fileTo);
    }

}
