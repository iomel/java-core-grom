package lesson17.home;

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

    public void maxWord(String input) {
        if (input == null || input.isEmpty())
            return;

        while (input.contains("  "))
            input = input.replaceAll("  ", " ");

        String[] strArray = input.split(" ");
        String maxW = strArray[0];
        for (String s : strArray) {
            if (!checkLetter(s))
                continue;
            if (s.length() > maxW.length())
                maxW = s;
        }
        System.out.println(maxW);
    }

    public void minWord(String input) {
        if (input == null || input.isEmpty())
            return;
        while (input.contains("  "))
            input = input.replaceAll("  ", " ");
        String[] strArray = input.split(" ");
        String minW = strArray[0];
        for (String s : strArray) {
            if (!checkLetter(s))
                continue;
            if (s.length() < minW.length())
                minW = s;
        }
        System.out.println(minW);

    }

    public String mostCountedWord(String input) {
        if (input == null)
            return null;

        while (input.contains("  "))
            input = input.replaceAll("  ", " ");
        String[] strArray = input.split(" ");
        int maxCount = 1;
        String resString = strArray[0];
        for (int i = 0; i < strArray.length; i++) {
            int count = 1;
            for (int j = i + 1; j < strArray.length; j++) {
                if (strArray[i].equals(strArray[j]))
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                resString = strArray[i];
            }
        }
        return resString;
    }

    public boolean validate(String address) {
        if (address == null)
            return false;

        address = address.toLowerCase();
        int startBit;
        if (!(address.startsWith("http://") || address.startsWith("https://")))
            return false;
        else if (address.startsWith("http://"))
            startBit = 7;
        else
            startBit = 8;

        if (!(address.endsWith("com") || address.endsWith("net") || address.endsWith("org")))
            return false;
        if (address.contains(".."))
            return false;

        String exectAddress = address.substring(startBit);
        String[] domains = exectAddress.split("\\.");
        if (domains[0].isEmpty())
            return false;

        for (String str : domains) {
            if (!checkLetterNumber(str))
                return false;
        }
        return true;
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
