package vn.edu.likelion.application;

import vn.edu.likelion.lession1.Palindrome;
import vn.edu.likelion.lession2.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Moring Homework: Find the average within variable number of doubles
        List<Number> list = Arrays.asList(8.7, 4.05, 6.33, 7.01, 2.8);

        double average = list.stream()
                .mapToDouble(Number::doubleValue)
                .average()
                .getAsDouble();

        System.out.println("the average: " + average);

        // lession 1
        Palindrome palindrome = new Palindrome();
        String[] strings = {"Madam", "radar", "defied"};

        for (String str : strings) {
            System.out.println(str + " is a is palindrome? " + palindrome.checkPalindrome(str));
        }

        // lession 2
        Integer[] nums = {1, 7, 18, 25, 77, 300, 101
        };
        System.out.println("Array elements: " + Arrays.toString(nums));

        System.out.println("Second largest element: " + ArrayUtils.findSecondLargest(nums));
        System.out.println("The smallest element: " + ArrayUtils.findSmallest(nums));
    }
}
