public class Main {
    public static void main(String[] args){
        Vehicle truck = new Truck("Tatra 810 4x4", 8.075659532105526, 65.50975012444003, 80.0);
        Vehicle car = new Car("Virtus", 2.355, 14.419665, 120.0);
        Vehicle motorcycle = new Motorcycle("Warrior200", 2.1, 4.41, 80.0);

        truck.printDetails();
        System.out.println();
        car.printDetails();
        System.out.println();
        motorcycle.printDetails();
    }
}
