package vn.edu.likelion.lession2;

public class Print {
     void printEvenNum(int num) {
        System.out.println(Thread.currentThread().getName() + " " + num);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

     void printOddNum(int num) {
        System.out.println(Thread.currentThread().getName() + " " + num);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
