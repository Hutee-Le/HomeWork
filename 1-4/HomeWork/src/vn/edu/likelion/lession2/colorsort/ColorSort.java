package vn.edu.likelion.lession2.colorsort;

import java.util.ArrayList;
import java.util.List;

public class ColorSort {
    private static List<String> getSort(List<String> colors) {
        List<String> sortList = new ArrayList<>(colors);
        int n = sortList.size();
        for (int i = 0; i < n - 1;  i++){
            for (int j = 0; j < n - i - 1; j++){
                if (sortList.get(j).compareTo(sortList.get(j+1)) >0){
                    String temp = sortList.get(j);
                    sortList.set(j, sortList.get(j + 1));
                    sortList.set(j+1, temp);
                }
            }
        }
        return sortList;
    }

    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Orange");
        colors.add("White");
        colors.add("Black");

        System.out.println("List before sort: " + colors);

        System.out.println("List after sort: " + getSort(colors));
    }
}
