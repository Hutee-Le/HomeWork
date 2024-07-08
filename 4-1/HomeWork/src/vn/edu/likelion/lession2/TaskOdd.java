package vn.edu.likelion.lession2;

public class TaskOdd implements Runnable {
    private Print sp;
    private int max;

    public TaskOdd(Print sp, int i){
        this.sp = sp;
        this.max = i;
    }

    @Override
    public void run() {
        for (int i = 1; i <= max; i = i + 2) {
            sp.printOddNum(i);
        }
    }
}
