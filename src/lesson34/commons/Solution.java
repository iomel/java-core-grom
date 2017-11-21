package lesson34.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Solution {

    public void copyFileContent(String fileFromPath, String fileToPath) throws Exception {

            validate(fileFromPath, fileToPath);

            try {
                Files.copy(new File(fileFromPath).toPath(), new File(fileToPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
    }

    public void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {

        validate(fileFromPath, fileToPath);

        try {
            FileUtils.writeLines(new File(fileToPath), FileUtils.readLines(new File(fileFromPath), "UTF-8"), true);
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
            throw new IOException("Can't read file" + fileFrom);
        if (!fileTo.canWrite())
            throw new IOException("Can't write to file" + fileTo);
    }

}
