package vn.edu.likelion.lession1;

public class Array {

    public static void pushZeroToEnd(int[] arr) {
        int countZero = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[countZero++] = arr[i];
            }
        }

        while (countZero < arr.length) {
            arr[countZero++] = 0;
        }
    }
}
