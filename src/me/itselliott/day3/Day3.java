package me.itselliott.day3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by Elliott on 11/12/2015.
 */
public class Day3 {

    private static final String fileName = "directions.txt";

    public static void main(String[] args) {
        Set<Point> houses = new HashSet<>(); // Task 1
        Set<Point> santa = new HashSet<>(); // Task 2
        Set<Point> robosanta = new HashSet<>(); // Task 2
        int count = 0; // Task 1
        int count2 = 0; // Task 2
        int x = 0; // Task 1
        int y = 0; // Task 1
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Day3.class.getResource(fileName).getPath()));
            String string = reader.readLine();
            for (int i = 0; i < string.length(); i++) {
                // Task 1 - Start
                if (string.charAt(i) == '^')
                    y++;
                else if (string.charAt(i) == 'v')
                    y--;
                else if (string.charAt(i) == '>')
                    x++;
                else if (string.charAt(i) == '<')
                    x--;
                houses.add(new Point(x,y));
                // Task 1 - Finish
            }
            // Task 2 - Start
            int sX = 0; // Santa X
            int sY = 0; // Santa Y
            int rX = 0; // RoboStanta X
            int rY = 0; // RoboStanta Y
            boolean santaHouse = true;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '^')
                    if (santaHouse)
                        sY++;
                    else
                        rY++;
                else if (string.charAt(i) == 'v')
                        if (santaHouse)
                            sY--;
                        else
                            rY--;
                else if (string.charAt(i) == '>')
                    if (santaHouse)
                        sX++;
                    else
                        rX++;
                else if (string.charAt(i) == '<')
                    if (santaHouse)
                        sX--;
                    else
                        rX--;
                robosanta.removeAll(santa);
                if (santaHouse)
                    santa.add(new Point(sX, sY));
                else
                    robosanta.add(new Point(rX, rY));
                santaHouse = !santaHouse;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("[First Year] Amount of house with at least 1 preset: " + houses.size());
        System.out.println("[Second Year] Amount of house with at least 1 preset: " + (santa.size() + robosanta.size()));
    }



}
