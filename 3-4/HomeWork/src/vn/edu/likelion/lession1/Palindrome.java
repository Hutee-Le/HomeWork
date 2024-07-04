package vn.edu.likelion.lession1;

import java.util.Locale;
import java.util.function.Predicate;

public class Palindrome {
    public static final Predicate<String> isPalindrome = string -> {
        String reversed = new StringBuilder(string).reverse().toString();
        return string.equals(reversed);
    };

    public boolean checkPalindrome(String text){
        return isPalindrome.test(text);
    }
}
