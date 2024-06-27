package vn.edu.likelion.lession1;

public class lession1 {
    public static boolean checkDigitIsEven(int number){
        if (number == 0) {
            return false;
        }

        while (number != 0){
            if ((number % 10) % 2 != 0){
                return false;
            }

            number /= 10;
        }

        return true;
    }
}
