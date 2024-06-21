package vn.edu.likelion.lession05;

public class Swap {
    public static void swapString(String str1, String str2){
        str1 += str2;

        str2 = str1.substring(0, str1.length() - str2.length());

        str1 = str1.substring(str2.length());

        System.out.println("Swapped str1: " + str1 + " " + "Swapped str2: " + str2);
    }
}
