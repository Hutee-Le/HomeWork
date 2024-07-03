package vn.edu.likelion.lession2;

import java.util.function.Function;

public class Tranform {
    private final Function<Integer, String> convert;

    public Tranform() {
        this.convert = number -> Integer.toBinaryString(number);
    }

    public String convertToBinary(int number) {
        return convert.apply(number);
    }
}
