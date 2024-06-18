public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Avril Aroldo", "123 Main St", 40000, "Manager");
        Developer developer = new Developer("Iver Dipali", "456 Elm St", 36000, "Developer");
        Programmer programmer = new Programmer("Yaron Gabriel", "789 Oak St", 36480, "Programmer");

        System.out.println("Manager's Bonus: $" + manager.calculateBonus());
        System.out.println("Developer's Bonus: $" + developer.calculateBonus());
        System.out.println("Programmer's Bonus: $" + programmer.calculateBonus());

        System.out.println("Performance report for Manager " + manager.name + ": " + manager.generatePerformanceReport());
        System.out.println("Performance report for Developer " + developer.name + ": " + developer.generatePerformanceReport());
        System.out.println("Performance report for Programmer " + programmer.name + ": " + programmer.generatePerformanceReport());

        manager.manageProject();
        developer.writeCode();
        programmer.debugCode();
    }
}
