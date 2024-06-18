public class Vehicle {
    String model;
    double fuelEfficiency;
    double distanceTraveled;
    double maxSpeed;

    public Vehicle(String model, double fuelEfficiency, double distanceTraveled, double maxSpeed) {
        this.model = model;
        this.fuelEfficiency = fuelEfficiency;
        this.distanceTraveled = distanceTraveled;
        this.maxSpeed = maxSpeed;
    }

    public void printDetails() {
        System.out.println("Vehicle Model: " + model);
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " mpg");
        System.out.println("Distance Traveled: " + distanceTraveled + " miles");
        System.out.println("Max Speed: " + maxSpeed + " mph");
    }
}
