package vn.edu.likelion.lession1;

import java.util.List;

public class Calculate {
    public static int getSumOfEvens(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int getSumOfOdds(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
