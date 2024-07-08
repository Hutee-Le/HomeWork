package vn.edu.likelion.application;

import vn.edu.likelion.lession1.Printer;
import vn.edu.likelion.lession1.TaskEvenOdd;

public class Application{
    public static void main(String[] args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, 20, false),"Even Number from evenThread: ");
        Thread t2 = new Thread(new TaskEvenOdd(print, 20, true),"Odd Number from oddThread: ");
        t1.start();
        t2.start();
    }
}
