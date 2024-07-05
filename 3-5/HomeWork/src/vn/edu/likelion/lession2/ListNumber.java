package vn.edu.likelion.lession2;

import java.util.List;
import java.util.stream.Collectors;

public class ListNumber {
    public static List<Integer> removeDuplicateNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().collect(Collectors.toList());
    }
}
