package me.itselliott.Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Elliott on 13/12/2015.
 */
public class Day6 {

    private static final String fileName = "instructions.txt";

    public static void main (String[] args) {
        int light = 0; // Part 1
        int bright = 0; // Part 2
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Day6.class.getResource(fileName).getPath()));
            String string;
            boolean[][] lights = new boolean[1000][1000]; // Part 1
            int[][] brightness = new int[1000][1000]; // Part 2
                      while ((string = reader.readLine()) != null) {
                String[] instruction = string.split(" ");
                int[] coordinate1 = new int[2];
                int[] coordinate2 = new int[2];
                if (instruction[0].equals("turn")) {
                    coordinate1[0] = Integer.parseInt(instruction[2].split(",")[0]);
                    coordinate1[1] = Integer.parseInt(instruction[2].split(",")[1]);
                    coordinate2[0] = Integer.parseInt(instruction[4].split(",")[0]);
                    coordinate2[1] = Integer.parseInt(instruction[4].split(",")[1]);
                    for (int i = coordinate1[0]; i <= coordinate2[0]; i++) {
                        for (int j = coordinate1[1]; j <= coordinate2[1]; j++) {
                            if (instruction[1].equals("on")) {
                                lights[i][j] = true;
                                brightness[i][j]++;
                            } else if (instruction[1].equals("off")) {
                                lights[i][j] = false;
                                brightness[i][j] = brightness[i][j]-- > 0 ? brightness[i][j]-- : 0;
                            }
                        }
                    }
                } else if (instruction[0].equals("toggle")) {
                    coordinate1[0] = Integer.parseInt(instruction[1].split(",")[0]);
                    coordinate1[1] = Integer.parseInt(instruction[1].split(",")[1]);
                    coordinate2[0] = Integer.parseInt(instruction[3].split(",")[0]);
                    coordinate2[1] = Integer.parseInt(instruction[3].split(",")[1]);

                    for (int i = coordinate1[0]; i <= coordinate2[0]; i++) {
                        for (int j = coordinate1[1]; j <= coordinate2[1]; j++) {
                            lights[i][j] = !lights[i][j];
                            brightness[i][j] += 2;
                        }
                    }
                }
            }
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    // Part 1
                    if (lights[i][j])
                        light++;
                    // Part 2
                    bright += brightness[i][j];
                }
            }
            System.out.println("Lights on: " + light);
            System.out.println("Brightness: " + bright);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
