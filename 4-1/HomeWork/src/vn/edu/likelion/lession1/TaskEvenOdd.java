package vn.edu.likelion.lession1;

public class TaskEvenOdd implements Runnable{
    private int max;
    private Printer print;
    private boolean isOddNumber;

    public TaskEvenOdd(Printer print, int i, boolean b) {
        this.print = print;
        this. max = i;
        this.isOddNumber = b;
    }

    @Override
    public void run() {
        int number = isOddNumber ? 1 : 2 ;
        while (number <= max) {
            if (isOddNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
}
