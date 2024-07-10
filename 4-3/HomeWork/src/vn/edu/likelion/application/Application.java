package vn.edu.likelion.application;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int[] nums = {5, 6, 1, 3, 4, 10, 2, 2, 3};

        // way 01;
        sortByMap(nums);

        System.out.print("Array sort: ");
        for (int num: nums) {
            System.out.print(num + " ");
        }

        // way 02
    }

    public static int[] sortByMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int min = nums[0], max = nums[0];

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

            if (nums[i] < min) min = nums[i];

            if (nums[i] > max) max = nums[i];
        }

        int index = 0;
        for (int i = min; i <= max; i++){
            while (map.getOrDefault(i, 0) > 0){
                nums[index] = i;
                index++;
                map.put(i, map.get(i) - 1);
            }
        }
        return nums;
    }
}
