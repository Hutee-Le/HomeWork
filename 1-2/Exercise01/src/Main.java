public class Main {
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle(10);
        vehicle.speedUp();

        Car car = new Car(10);
        car.speedUp();

        Bicycle bicycle = new Bicycle(10);
        bicycle.speedUp();
    }
}
