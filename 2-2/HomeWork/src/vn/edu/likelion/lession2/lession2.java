package vn.edu.likelion.lession2;

public class lession2 {
    public static boolean checkDigitIsEven(int number){
        if (number == 0) {
            return false;
        }

        while (number != 0){
            if ((number % 10) % 2 != 0){
                return true;
            }

            number /= 10;
        }

        return false;
    }
}
