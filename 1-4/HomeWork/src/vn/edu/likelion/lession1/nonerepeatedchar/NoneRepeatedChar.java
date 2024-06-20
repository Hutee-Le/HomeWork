package vn.edu.likelion.lession1.nonerepeatedchar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoneRepeatedChar {
    /**
     * Finds the first non repeated character in the given string.
     *
     * @param text The input string.
     * @return The first non repeated character or 0 if none found.
     */
    public static char findFirstNonRepeatedChar(String text) {
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }

        return 0;
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("The given string is: ");
        String input = scanner.nextLine();

        char result = findFirstNonRepeatedChar(input);
        if(result != 0) {
            System.out.println("The first none repeated character in String is: " + result);
        } else {
            System.out.println("No none repeated character found.");
        }

    }
}
