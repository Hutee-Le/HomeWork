package vn.edu.likelion.application;

import vn.edu.likelion.lession1.Array;
import vn.edu.likelion.lession2.lession2;
import vn.edu.likelion.lession3.Number;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // lession 01
        int[] arr = {0, 0, 1, 0, 3, 0, 5, 0, 6};

        System.out.println("Original array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        Array.pushZeroToEnd(arr);

        System.out.println("\nAfter moving 0's to the end of the array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n---------------------------------------------------------");
        // lession 02
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input an integer: ");
        int input = scanner.nextInt();

        System.out.println("Check whether every digit of the said integer is even or not!");
        System.out.println(lession2.checkDigitIsEven(input));

        System.out.println("\n---------------------------------------------------------");
        System.out.print("Input an integer(positive/negative): ");
        int inputNumber = scanner.nextInt();
        System.out.println("Extract the first digit form the said integer:");
        System.out.println(Number.checkFirstDigit(inputNumber));
    }
}
