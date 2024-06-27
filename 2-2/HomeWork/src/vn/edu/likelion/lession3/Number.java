package vn.edu.likelion.lession3;

public class Number {
    public static int checkFirstDigit(int number) {
        String stringNumber = Integer.toString(number);

        if (stringNumber.charAt(0) == '-') {
            stringNumber = stringNumber.substring(1);
        }

        int firstDigit = Character.getNumericValue(stringNumber.charAt(0));

        return firstDigit;
    }
}
