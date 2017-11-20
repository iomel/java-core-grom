package lesson34.sentences;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath);

        HashMap<String, ArrayList<String>> dividedSentences = divideText(readFile(fileFromPath), word);
        writeFile(fileToPath, prepareContentForLoad(dividedSentences.get("hasWord")));
        writeFile(fileFromPath, prepareContentForLoad(dividedSentences.get("noWord")));

    }

    private HashMap<String, ArrayList<String>> divideText(String content, String word) {
        ArrayList<String> hasWord = new ArrayList<>();
        ArrayList<String> hasNoWord = new ArrayList<>();
        HashMap<String, ArrayList<String>> result = new HashMap<>();

        for (String sentence : content.split("\\.")) {
            System.out.println(sentence);
            if (sentence.length() > 10 && sentence.contains(word))
                hasWord.add(sentence);
            else
                hasNoWord.add(sentence);
        }

        result.put("hasWord", hasWord);
        result.put("noWord", hasNoWord);
        return result;
    }

    private String prepareContentForLoad(ArrayList<String> sentences) {
        String result = "";
        for (String phrase : sentences)
            result = result.concat(phrase).concat(".");

        return result;
    }

    private String readFile(String path) throws Exception {
        String content = new String();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null)
                content = content.concat("\n").concat(line);
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

    private void makeTMP (String path) throws Exception{
        File tmpFile = new File(path + ".tmp");
        tmpFile.deleteOnExit();
        writeFile(tmpFile.getPath(), readFile(path), false);
    }

    private void restore(String path){
        File fileToRestore = new File(path);
        File tmpFile = new File(path + ".tmp");
        fileToRestore.delete();
        tmpFile.renameTo(fileToRestore);
    }
}
