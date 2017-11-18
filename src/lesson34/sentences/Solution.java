package lesson34.sentences;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception{
        validate(fileFromPath, fileToPath);

        HashMap<String, ArrayList<String>> dividedSentences = new HashMap<>();
        String sourceContent = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileFromPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileToPath,true))){

            while (br.ready())
                sourceContent = sourceContent.concat("\n").concat(br.readLine());
            dividedSentences = divideText(sourceContent, word);
            bw.append(prepareContentForLoad(dividedSentences.get("hasWord")));
            bw.flush();
        } catch (FileNotFoundException e){
            System.err.println("File not found!");
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileFromPath))){
            bw.write(prepareContentForLoad(dividedSentences.get("noWord")));
            bw.flush();
        }

}

    private HashMap<String, ArrayList<String>> divideText(String content, String word){
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

    private String prepareContentForLoad(ArrayList<String> sentences){
        String result = "";
        for (String phrase : sentences)
            result = result.concat(phrase).concat(".");

        return result;
    }

    private void validate(String fileFromPath, String fileToPath) throws Exception{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileFrom.exists())
            throw new FileNotFoundException("File " + fileFrom + "does not exist");
        if (!fileTo.exists())
            throw new FileNotFoundException("File " + fileTo + "does not exist");
        if (!fileFrom.canRead() || !fileFrom.canWrite())
            throw new Exception("Can't read file" + fileFrom);
        if (!fileTo.canWrite())
            throw new Exception("Can't write to file" + fileTo);
    }

}
