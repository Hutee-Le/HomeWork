public class Manager extends Employee {
    public Manager(String name, String address, double salary, String jobTitle) {
        super(name, address, salary, jobTitle);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.3;
    }

    @Override
    public String generatePerformanceReport() {
        return "Excellent";
    }

    @Override
    public void manageProject() {
        System.out.println("Manager " + name + " is managing a project.");
    }
}
