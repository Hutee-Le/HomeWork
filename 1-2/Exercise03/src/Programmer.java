public class Programmer extends Employee{
    public Programmer(String name, String address, double salary, String jobTitle) {
        super(name, address, salary, jobTitle);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.25;
    }

    @Override
    public String generatePerformanceReport() {
        return "Excellent";
    }

    public void debugCode() {
        System.out.println("Programmer " + name + " is debugging code in Python");
    }
}
