package vn.edu.likelion.lession2.colorsort;

import java.util.ArrayList;
import java.util.Collections;

public class ColorSort {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Orange");
        colors.add("White");
        colors.add("Black");

        System.out.println("List before sort: " + colors);
        Collections.sort(colors);
        System.out.println("List after sort: " + colors);
    }
}
