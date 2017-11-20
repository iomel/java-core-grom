package lesson34.transfer;

import java.io.*;

public class Solution {

    public void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);

        // Create backup of files before transfer
        // and save content before transfer
        StringBuffer sourceContent = readFile(fileFromPath);
        StringBuffer destinationContent = readFile(fileToPath);

        // Try to copy content to destination
        try {
            writeFile(fileToPath, sourceContent, true);
        } catch (IOException e){
            // In case of error restore destination file from backup file
            writeFile(fileToPath, destinationContent, false);
            throw new IOException(e.getMessage());
        }

        // Try to clear source file to finish transfer
        try {
            writeFile(fileFromPath, new StringBuffer(""), false);
        } catch (IOException e){
            // In case of error restore all files from backup files
            writeFile(fileToPath, destinationContent, false);
            writeFile(fileFromPath, sourceContent, false);
            throw new IOException(e.getMessage());
        }
    }

    private StringBuffer readFile(String path) throws Exception {
        StringBuffer content = new StringBuffer();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null)
                content = content.append("\n").append(line);
            content = new StringBuffer(content.substring(1));
        } catch (IOException e) {
            throw new IOException("Can't read file " + path);
        }
        return content;
    }

    private void writeFile(String path, StringBuffer content, boolean param) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, param))) {
            bw.append(content);
        } catch (IOException e) {
            throw new IOException("Can't write file " + path);
        }
    }

    private void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists())
            throw new FileNotFoundException("File " + fileFromPath + " does not exist");
        if (!fileTo.exists())
            throw new FileNotFoundException("File " + fileToPath + " does not exist");
        if (!fileFrom.canRead() || !fileFrom.canWrite())
            throw new Exception("Can't transfer from file " + fileFromPath);
        if (!fileTo.canWrite() || !fileTo.canWrite())
            throw new Exception("Can't transfer to to file " + fileToPath);
    }
}