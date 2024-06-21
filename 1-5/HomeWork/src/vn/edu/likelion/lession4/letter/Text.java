package vn.edu.likelion.lession4.letter;

import java.util.HashSet;

public class Text {
    /**
     * @param text @{string}
     * @return string within duplicate character
     */
    public static String removeDuplicates(String text) {
        StringBuilder uniString = new StringBuilder();
        HashSet<Character> uniChars = new HashSet<>();

        for (char ch : text.toCharArray()) {
            if (uniChars.add(ch)) {
                uniString.append(ch);
            }
        }

        return uniString.toString();
    }
}
