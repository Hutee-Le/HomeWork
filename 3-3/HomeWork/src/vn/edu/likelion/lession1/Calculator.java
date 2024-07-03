package vn.edu.likelion.lession1;

import java.util.function.Function;

public class Calculator {
    private final Function<Integer, Integer> largestNumber;

    public Calculator() {
        this.largestNumber = number -> {
            int largestFactor = 1;

            while (number % 2 == 0) {
                largestFactor = 2;
                number /= 2;
            }

            for (int i = 3; i <= Math.sqrt(number); i +=2) {
                while (number % i == 0) {
                    largestFactor = i;
                    number /= i;
                }
            }

            if (number > 2) {
                largestFactor = number;
            }

            return largestFactor;
        };
    }

    public int getLargestNumber(int number) {
        return largestNumber.apply(number);
    }
}
