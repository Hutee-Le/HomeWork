public class Developer extends Employee {
    public Developer(String name, String address, double salary, String jobTitle) {
        super(name, address, salary, jobTitle);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.2;
    }

    @Override
    public String generatePerformanceReport() {
        return "Good";
    }

    public void writeCode() {
        System.out.println("Developer " + name + " is writing code in Java");
    }
}
