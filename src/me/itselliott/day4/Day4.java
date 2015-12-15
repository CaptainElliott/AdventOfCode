package me.itselliott.day4;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Elliott on 12/12/2015.
 */
public class Day4 {

    public static void main(String[] args) {
        long index = 0;
        String string = "iwrupvqb";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            while (true) {
                String key = String.format("%s%d", string, index++);
                byte [] digest = md.digest(key.getBytes());
                if (DatatypeConverter.printHexBinary(digest).startsWith("000000")) {
                    break;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        System.out.println((index - 1));
    }

}
