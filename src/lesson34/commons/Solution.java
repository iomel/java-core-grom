package lesson34.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Solution {
    public void copyFileContent(String fileFromPath, String fileToPath) {

        File sourceFile = new File(fileFromPath);
        File destinationFile = new File(fileToPath);

        if (sourceFile.exists() && sourceFile.canRead() && !destinationFile.exists())
            try {
                Files.copy(sourceFile.toPath(), destinationFile.toPath());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
    }

    public void copyFileContentApacheIO(String fileFromPath, String fileToPath) {
        try {
            FileUtils.writeLines(new File(fileToPath), FileUtils.readLines(new File(fileFromPath), "UTF-8"), true);
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

}
