package lesson34.sentences;

import java.io.*;

public class Solution {

    public void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath);

        // Create backup of files before transfer and save content before transfer
        String sourceContent = readFile(fileFromPath);
        String destinationContent = readFile(fileToPath);

        // divide content for two parts : WITH WORD | WITHOUT WORD
        String hasWord = "";
        String noWord = "";
        for (String sentence : sourceContent.split("\\."))
            if (sentence.length() > 10 && sentence.contains(word))
                hasWord = hasWord.concat(sentence).concat(".");
            else
                noWord = noWord.concat(sentence).concat(".");

         try {
            if (!hasWord.isEmpty()) {
                writeFile(fileToPath, hasWord, true);
                writeFile(fileFromPath, noWord, false);
            }
         } catch (IOException e){
            // In case of error in destination write - restore fileTo , otherwise restore all files
            writeFile(fileToPath, destinationContent, false);
            if (e.getMessage().contains(fileFromPath))
                writeFile(fileFromPath, sourceContent, false);
            throw new IOException(e.getMessage());
        }
    }


    private String readFile(String path) throws Exception {
        String content = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null)
                content = content.concat("\n").concat(line);
            if(content.length() > 1)
                content = content.substring(1);
        } catch (IOException e) {
            throw new IOException("Can't read file " + path);
        }
        return content;
    }

    private void writeFile(String path, String content, boolean param) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, param))) {
            bw.append(content);
        } catch (IOException e) {
            throw new IOException("Can't write to file " + path);
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
            throw new IOException("Can't transfer from file " + fileFromPath);
        if (!fileTo.canWrite() || !fileTo.canWrite())
            throw new IOException("Can't transfer to file " + fileToPath);
    }
}
