package me.itselliott.day1;

import java.io.*;

/**
 * Day 1 of http://adventofcode.com/
 * http://adventofcode.com/day/1
 */
public class Day1 {

    private static final String fileName = "parenthesis.txt";
    private static int floor = 0;

    public static void main (String[] args) {
        boolean enteredBasement = false; // Task 2
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Day1.class.getResource(fileName).getPath()));
            String string = reader.readLine();
            for (int i = 0; i < string.length(); i++) {
                // Task 1 - Start
                if (string.charAt(i) == '(')
                    floor++;
                else if (string.charAt(i) == ')')
                    floor--;
                // Task 1 - Finish

                //Task 2 - Start
                if (floor == -1 && !enteredBasement) {
                    enteredBasement = true;
                    System.out.println("Entered basement at: " + (i+1));
                }
                //Task 2 - Finish
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Floor: " + floor);
    }



}
