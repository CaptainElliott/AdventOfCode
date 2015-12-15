package me.itselliott.Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Elliott2 on 15/12/2015.
 * Day 8 Unfinished
 */
public class Day8 {

    private static final String fileName = "characters.txt";

    public static void main (String[] args) {
        int literalSize = 0;
        int memSize = 0;
        int size = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Day8.class.getResource(fileName).getPath()));
            String string;
            while ((string = reader.readLine()) != null) {
                string = string.trim();
                literalSize += string.length();
                String temp = string.substring(1, string.length() - 1);
                temp = temp.replaceAll("\\\\x..", "H");
                temp = temp.replaceAll("\\\\", "/");
                temp = temp.replaceAll("\\\\\"", "S");
                temp = temp.trim();
                memSize += temp.length();
            }
            size = literalSize - memSize;
            System.out.println("Literal Size: " + literalSize);
            System.out.println("Size in Memory: " + memSize);
            System.out.println("Literal - Memory " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
