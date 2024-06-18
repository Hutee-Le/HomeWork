public class Motorcycle extends Vehicle {
    public Motorcycle(String model, double fuelEfficiency, double distanceTraveled, double maxSpeed) {
            super(model, fuelEfficiency, distanceTraveled, maxSpeed);
        }

        @Override
        public void printDetails() {
            System.out.println("Motorcycle Model: " + model);
            System.out.println("Fuel Efficiency: " + fuelEfficiency + " mpg");
            System.out.println("Distance Traveled: " + distanceTraveled + " miles");
            System.out.println("Max Speed: " + maxSpeed + " mph");
        }
}
