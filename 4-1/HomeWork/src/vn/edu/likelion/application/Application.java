package vn.edu.likelion.application;

import vn.edu.likelion.lession1.Printer;
import vn.edu.likelion.lession1.TaskEvenOdd;
import vn.edu.likelion.lession2.Print;
import vn.edu.likelion.lession2.TaskEven;
import vn.edu.likelion.lession2.TaskOdd;

public class Application{
    public static void main(String[] args) {
//        // way 1
//        Printer print = new Printer();
//        Thread t1 = new Thread(new TaskEvenOdd(print, 20, false),"Even Number from evenThread: ");
//        Thread t2 = new Thread(new TaskEvenOdd(print, 20, true),"Odd Number from oddThread: ");
//        t1.start();
//        t2.start();

        // way 2
        Print print1 = new Print();
        Thread t3 = new Thread(new TaskEven(print1, 20),"Even Number from evenThread: ");
        Thread t4 = new Thread(new TaskOdd(print1, 20),"Odd Number from oddThread: ");

        t3.start();
        t4.start();
    }
}
