package vn.edu.likelion.lession1.distinctsum;

import java.util.HashSet;
import java.util.Set;

public class DistinctSum {
    /**
     * @param array
     * @return sum of distinct element in array
     */
    public static int sumOfDistinctElement(int[] array) {
        Set<Integer> uniNumber = new HashSet<>();

        for(int item: array){
            uniNumber.add(item);
        }

        int result = 0;
        for(int item: uniNumber) {
            result += item;
        }

        return result;
    }
}
