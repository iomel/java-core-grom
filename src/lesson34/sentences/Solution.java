package lesson34.sentences;

import java.io.*;

public class Solution {

    public void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath);

        // Create backup of files before transfer and save content before transfer
        String sourceContent = readFile(fileFromPath);
        String destinationContent = readFile(fileToPath);

        // divide content for two parts : WITH WORD  - 0 index element | WITHOUT WORD  - 1 index element
        String[] phrases = divideText(sourceContent, word);  // 0 - has word  |  1 - no word sentences

         try {
            if (phrases[0].length() > 0) {
                writeFile(fileToPath, phrases[0], true);
                writeFile(fileFromPath, phrases[1], false);
            }
         } catch (IOException e){
            // In case of error restore all files
            writeFile(fileToPath, destinationContent, false);
            if (e.getMessage().contains(fileFromPath))
                writeFile(fileFromPath, sourceContent, false);
            throw new IOException(e.getMessage());
        }
    }

    private String[] divideText(String content, String word) {
        String[] result = new String[] {"",""};
        for (String sentence : content.split("\\."))
            if (sentence.length() > 10 && sentence.contains(word))
                result[0] = result[0].concat(sentence).concat(".");
            else
                result[1] = result[1].concat(sentence).concat(".");
        return result;
    }


    private String readFile(String path) throws Exception {
        String content = new String();
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
            throw new FileNotFoundException("File " + fileFrom.getPath() + " does not exist");
        if (!fileTo.exists())
            throw new FileNotFoundException("File " + fileTo.getPath() + " does not exist");
        if (!fileFrom.canRead() || !fileFrom.canWrite())
            throw new Exception("Can't transfer from file " + fileFrom.getPath());
        if (!fileTo.canWrite() || !fileTo.canWrite())
            throw new Exception("Can't transfer to file " + fileTo.getPath());
    }
}
