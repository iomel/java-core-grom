package lesson17.home;


import java.util.Arrays;

public class Solution {


    public int countWords(String input) {
        if (input == null || input.isEmpty())
            return 0;

        while (input.contains("  "))
            input = input.replaceAll("  ", " ");

        int count = 0;
        for (String str : input.split(" ")) {
            if (str.isEmpty() || str.equals(" "))
                continue;
            if (str.toCharArray()[0] == ' ')
                str = str.replace(" ", "");
            if (checkLetter(str))
                count++;
        }
        return count;
    }

    public String maxWord(String input) {
        if (input == null || input.isEmpty())
            return null;

        while (input.contains("  ")) {
            input = input.replaceAll("  ", " ");
        }

        String maxW = "";
        for (String s : input.split(" ")) {
            s = s.trim();
            if (!checkLetter(s) || s.isEmpty() || s.equals(" "))
                continue;
            if (s.length() > maxW.length())
                maxW = s;
        }
        if (maxW.isEmpty())
            return null;
        return maxW;
    }

    public String minWord(String input) {
        if (input == null || input.isEmpty())
            return null;
        while (input.contains("  "))
            input = input.replaceAll("  ", " ");

        String minW = "";
        boolean first = false;
        for (String s : input.split(" ")) {
            s = s.trim();
            if (!checkLetter(s) || s.isEmpty() || s.equals(" "))
                continue;
            first = true;
            if (first && minW.isEmpty())
                minW = s;
            else if (s.length() < minW.length())
                minW = s;
        }
        if (minW.isEmpty() || minW.equals(" "))
            return null;
        return minW;
    }

    public String mostCountedWord(String input) {
        if (input == null || input.isEmpty())
            return null;

        input = input.trim();
        while (input.contains("  "))
            input = input.replaceAll("  ", " ");

        String[] strArray = input.split(" ");
        int maxCount = 0;
        String resString = "";
        for (int i = 0; i < strArray.length; i++) {
            if (!checkLetter(strArray[i]))
                continue;
            int count = 1;
            for (int j = i + 1; j < strArray.length; j++) {
                if (strArray[i].equals(strArray[j]))
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                resString = checkLetter(strArray[i]) ? strArray[i] : "";
            }
        }
        return resString.isEmpty() ? null : resString;
    }

    public boolean validate(String address) {
        if (address == null || address.isEmpty())
            return false;

        address = address.toLowerCase();

        if (!(address.endsWith("com") || address.endsWith("net") || address.endsWith("org")))
            return false;
        if (address.contains(".."))
            return false;

        int startBit;
        if (!(address.startsWith("http://") || address.startsWith("https://")))
            return false;
        else if (address.startsWith("http://"))
            startBit = 7;
        else
            startBit = 8;


        String exectAddress = address.substring(startBit, address.length()-4);
        if(exectAddress.startsWith("www."))
            exectAddress = exectAddress.substring(4);

/*        String[] domains = exectAddress.split("\\.");
        if (domains[0].isEmpty())
            return false;

        for (String str : domains) {
            if (!checkLetterNumber(str))
                return false;
        }
*/

        return checkLetterNumber(exectAddress);
    }

    public String replace(String input, String target, String replacement) {
        boolean startBit = input.startsWith(target);
        boolean endBit = input.endsWith(target);

        String[] arr = input.split(target);
        String result = "";
        if (startBit)
            result += replacement;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (i != arr.length - 1)
                result += replacement;
        }
        if (endBit)
            result += replacement;
        return result;
    }

    private boolean checkLetterNumber(String word) {
        for (char ch : word.toCharArray())
            if (!(Character.isLetter(ch) || Character.isDigit(ch)))
                return false;
        return true;
    }

    private boolean checkLetter(String word)

    {
        for (char ch : word.toCharArray())
            if (!Character.isLetter(ch))
                return false;

        return true;
    }
}
