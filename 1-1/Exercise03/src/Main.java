import java.util.Scanner;

public class Main {
    /*
     *  this is method to reverse a string
     *  @param string with type {String}
     *  return the reverse a string
     * */
    public static void getReverseString(String string){
        for (int i = (string.length() - 1); i >= 0; i--) {
            System.out.print(string.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vui long nhap chuoi ky tu: ");
        String input = scan.nextLine();

        getReverseString(input);
    }
}
