package vn.edu.likelion.lession2;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayUtils {

    public static Integer findSecondLargest(Integer[] nums) {
        return Arrays.stream(nums)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }

    public static Integer findSmallest(Integer[] nums) {
        return Arrays.stream(nums)
                .distinct()
                .sorted()
                .findFirst()
                .orElse(null);
    }
}
