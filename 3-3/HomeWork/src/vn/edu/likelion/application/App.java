package vn.edu.likelion.application;

import vn.edu.likelion.lession1.Calculator;
import vn.edu.likelion.lession2.Tranform;

public class App {
    public static void main(String[] args) {
        // lession 1
        Calculator calculator = new Calculator();
        int number1 = 176;
        int number2 = 36;

        System.out.println("Number: " + number1);
        System.out.println("Largest prime factor: " + calculator.getLargestNumber(number1));
        System.out.println("Number: " + number2);
        System.out.println("Largest prime factor: " + calculator.getLargestNumber(number2));

        // lession 2
        Tranform tranform = new Tranform();
        int number3 = 33;
        int number4 = 747;

        System.out.println("Number: " + number3);
        System.out.println("Binary representation: " + tranform.convertToBinary(number3));
        System.out.println("Number: " + number4);
        System.out.println("Binary representation: " + tranform.convertToBinary(number4));

    }
}
