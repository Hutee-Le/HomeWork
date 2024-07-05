package vn.edu.likelion.application;

import vn.edu.likelion.lession1.Calculate;
import vn.edu.likelion.lession2.ListNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // lession 1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14);
        System.out.println("List of numbers: " + numbers);
        System.out.println("Sum of even numbers: " + Calculate.getSumOfEvens(numbers));
        System.out.println("Sum of odd numbers: " + Calculate.getSumOfOdds(numbers));

        // lession 2
        List<Integer> originalList = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);

        System.out.println("Original List of numbers: " + originalList);
        System.out.println("After remove duplicates from the said list: " + ListNumber.removeDuplicateNumbers(originalList));
    }
}
