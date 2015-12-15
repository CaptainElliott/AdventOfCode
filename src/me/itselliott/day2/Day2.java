package me.itselliott.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Day 2 of http://adventofcode.com/
 * http://adventofcode.com/day/2
 */
public class Day2 {

    private static final String fileName = "dimensions.txt";

    public static void main (String[] args) {
        int surfaceArea = 0;
        int ribbon = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Day2.class.getResource(fileName).getPath()));
            String string;
            while ((string = reader.readLine()) != null) {
                // Task 1 - Start
                String[] dimensions = string.split("x");
                int length = Integer.parseInt(dimensions[0]);
                int width = Integer.parseInt(dimensions[1]);
                int height = Integer.parseInt(dimensions[2]);

                int lw = length * width;
                int lh = length * height;
                int wh = width * height;
                surfaceArea += (lw + lh + wh)*2 + Math.min(Math.min(lw, lh), wh);
                // Task 1 - Finish

                //Task 2 - Start
                List<Integer> list = Arrays.asList(length, width, height);
                Collections.sort(list);
                ribbon += 2*list.get(0) + 2*list.get(1);
                ribbon += length * width * height;
                //Task 2 - Finish
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total surface area needed: " + surfaceArea);
        System.out.println("Total ribbon needed: " + ribbon);
    }

}
