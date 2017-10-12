package lesson16.home;

import java.util.Arrays;

public class Solution {


    public int countWords(String input){
        if (input == null)
            return 0;
        while (input.contains("  "))
            input = input.replaceAll("  "," ");
        return input.split(" ").length;
    }

    public void maxWord(String input)
    {
        if (input == null)
            return;
        while (input.contains("  "))
            input = input.replaceAll("  "," ");
        String[] strArray = input.split(" ");
        String maxW = strArray[0];
        for (String s : strArray)
        {
            if (s.length() > maxW.length())
                maxW = s;
        }
        System.out.println(maxW);
    }
    public void minWord(String input)
    {
        if (input == null)
            return;
        while (input.contains("  "))
            input = input.replaceAll("  "," ");
        String[] strArray = input.split(" ");
        String minW = strArray[0];
        for (String s : strArray)
        {
            if (s.length() < minW.length())
                minW = s;
        }
        System.out.println(minW);

    }

    public String mostCountedWord(String input)
    {
        if (input == null)
            return null;

        while (input.contains("  "))
            input = input.replaceAll("  "," ");
        String[] strArray = input.split(" ");
        int maxCount = 1;
        String resString = strArray[0];
        for (int i = 0; i < strArray.length; i++)
        {
            int count = 1;
            for (int j = i+1; j < strArray.length; j++)
            {
                if (strArray[i].equals(strArray[j]))
                    count++;
            }
            if (count > maxCount)
            {
                maxCount = count;
                resString = strArray[i];
            }
        }
        return resString;
    }

    public boolean validate(String address)
    {
        if (address == null)
            return false;

        address = address.toLowerCase();
        int startBit;
        if (!(address.startsWith("http://") || address.startsWith("https://" )))
            return false;
        else if (address.startsWith("http://"))
            startBit = 7;
        else
            startBit = 8;

        if(!(address.endsWith("com") || address.endsWith("net") || address.endsWith("org")))
            return false;
        if (address.contains(".."))
            return false;

        String exectAddress = address.substring(startBit);
        String[] domains = exectAddress.split("\\.");
        if (domains[0].isEmpty())
            return false;

        for (String str : domains)
        {
            for (char ch : str.toCharArray())
                if(!((ch > 47 && ch < 58) || (ch > 64 && ch < 91) || (ch > 96 && ch < 123)))
                    return false;
        }
        return true;
    }

    public String replace (String input, String target, String  replacement)
    {
        boolean startBit = input.startsWith(target);
        boolean endBit = input.endsWith(target);

        String[] arr = input.split(target);
        String result = "";
        if(startBit)
            result += replacement;
        for(int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (i != arr.length-1)
                result += replacement;
        }
        if(endBit)
            result += replacement;
        return result;
    }
}
