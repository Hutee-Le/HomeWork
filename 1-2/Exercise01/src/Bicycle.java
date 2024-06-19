public class Bicycle extends Vehicle{
    public Bicycle(double speed){
        super(speed);
    }

    @Override
    public void speedUp(){
        speed += 30;
        System.out.println("Speed: " + this.speed);
    }
}
