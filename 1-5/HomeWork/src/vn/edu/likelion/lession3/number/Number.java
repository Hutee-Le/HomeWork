package vn.edu.likelion.lession3.number;

public class Number {
    public static void countOddEven(int[] array){
        int evenCount = 0;
        int oddCount = 0;

        for (int number: array){
            if (number % 2 == 0){
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Số phần tử chẵn: " + evenCount);
        System.out.println("Số phần tử lẻ: " + oddCount);
    }
}
