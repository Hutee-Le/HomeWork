package vn.edu.likelion.application;

import vn.edu.likelion.lession1.Array;

public class Application {
    public static void main(String[] args) {
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
    }
}
