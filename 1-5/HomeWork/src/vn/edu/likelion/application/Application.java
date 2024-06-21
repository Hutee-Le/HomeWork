package vn.edu.likelion.application;

import vn.edu.likelion.lession05.Swap;
import vn.edu.likelion.lession1.distinctsum.DistinctSum;
import vn.edu.likelion.lession2.letter.Letter;
import vn.edu.likelion.lession3.number.Number;
import vn.edu.likelion.lession4.letter.Text;

public class Application {
    public static void main(String[] args) {
        // lession 01
        int[] arr = {5, 1, 8, 4, 9, 1, 5};
        int distinctSum = DistinctSum.sumOfDistinctElement(arr);
        System.out.println("Output: " + distinctSum);

        // lession02
        String originString = "hello";
        String stringTwice = Letter.printLetterTwice(originString);
        System.out.println("Original String: " + originString);
        System.out.println("Output String: " + stringTwice);

        // lession03
        int[] array = {1,2,3,4,5,6,7,8,9};

        Number.countOddEven(array);

        // lession04
        String text = "characters";

        System.out.println("Input String: " + text);
        System.out.println("Output String: " + Text.removeDuplicates(text));

        // lession05
        String str1 = "Hello";
        String str2 = "World";

        System.out.println("Original str1: " + str1 + " " + "Original str2: " + str2);
        System.out.print("Output: ");
        Swap.swapString(str1, str2);
    }
}
