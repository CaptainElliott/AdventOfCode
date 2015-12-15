package me.itselliott.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Elliott on 13/12/2015.
 */
public class Day5 {

    private static final String fileName = "text.txt";

    public static void main(String[] args) {
        int vowelCount = 0;
        boolean hasDoubleLetter = false;
        boolean hasBlacklist = false;
        int niceStrings = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Day5.class.getResource(fileName).getPath()));
            String string;
            while ((string = reader.readLine()) != null) {
                for (int i = 0; i < string.length(); i++) {
                    if (isVowel(string.charAt(i)))
                        vowelCount++;
                    if (hasDoubleLetter(string, i))
                        hasDoubleLetter = true;
                    if (containsBlacklist(string, i))
                        hasBlacklist = true;

                }
                if (vowelCount >= 3 && hasDoubleLetter && !hasBlacklist)
                    niceStrings++;
                vowelCount = 0;
                hasBlacklist = false;
                hasDoubleLetter = false;
            }
            System.out.println("Nice Strings " + niceStrings);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean isVowel(char c) {
        char[] vowels = {'a','e','i','o','u'};
        for (char vowel : vowels) {
            if (c == vowel)
                return true;
        }
        return false;
    }

    private static boolean hasDoubleLetter(String string, int index) {
        return (string.length() > index + 1) && string.charAt(index) == string.charAt(index + 1);
    }

    private static boolean containsBlacklist(String string, int index) {
        if ((string.length() > index + 1)) {
            String[] blacklist = {"ab", "cd", "pq", "xy"};
            for (String s : blacklist) {
                if ((Character.toString(string.charAt(index)) + Character.toString(string.charAt(index + 1))).equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
