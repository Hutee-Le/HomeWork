package vn.edu.likelion.lession2;

public class TaskEven implements Runnable{
    private Print sp;
    private int max;

    public TaskEven(Print sp, int i){
        this.sp = sp;
        this.max = i;
    }

    @Override
    public void run() {
        for (int i = 2; i <= max; i = i + 2) {
            sp.printEvenNum(i);
        }
    }
}
