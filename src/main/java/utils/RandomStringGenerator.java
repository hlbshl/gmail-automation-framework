package utils;

import java.util.Random;

public class RandomStringGenerator  {
    public static String randomStringCreator() {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder result = new StringBuilder();
            Random random = new Random();
            int length = 5;

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                char randomChar = characters.charAt(index);
                result.append(randomChar);
            }
            return result + "@gmail.com";
        }
    }