public class Car extends Vehicle {
    public Car(String model, double fuelEfficiency, double distanceTraveled, double maxSpeed) {
        super(model, fuelEfficiency, distanceTraveled, maxSpeed);
    }

    @Override
    public void printDetails() {
        System.out.println("Car Model: " + model);
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " mpg");
        System.out.println("Distance Traveled: " + distanceTraveled + " miles");
        System.out.println("Max Speed: " + maxSpeed + " mph");
    }
}
