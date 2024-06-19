import java.util.Scanner;

public class Main {
    /*
     *  This method is used to print message input.
     *  @param string  the string to display from user input
     *  @return string This return message
     * */
    public static void printTypedString(String string){
        System.out.println(string);
    }

    public static void main(String[] args) {
        // Bai tap 2:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter message");

        String input = scanner.nextLine();
        printTypedString(input);
    }
}
