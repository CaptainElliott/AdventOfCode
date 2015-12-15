package me.itselliott.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by Elliott on 13/12/2015.
 */
public class Day5Part2 {

    private static final String fileName = "text.txt";


    public static void main(String[] args) {
        int niceStrings = 0;
        boolean doubleLetters;
        int repeatingLetters = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Day5Part2.class.getResource(fileName).getPath()));
            String string;
            while ((string = reader.readLine()) != null) {
                doubleLetters = doubleLetter(string);
                for (int i = 0; i < string.length(); i++) {
                    if (repeatingLetter(string, i ))
                        repeatingLetters++;
                }
                if (doubleLetters && repeatingLetters >= 1)
                    niceStrings++;
                doubleLetters = false;
                repeatingLetters = 0;
            }
            System.out.println("Nice Strings: " + niceStrings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean doubleLetter(String string) {
        Pattern pattern = Pattern.compile("(..).*\\1");
        return (pattern.matcher(string).find());
    }

    private static boolean repeatingLetter(String string, int index) {
        return  (((string.length() > index + 2) && string.charAt(index) == string.charAt(index + 2)) && string.charAt(index + 1) != string.charAt(index));
    }


}