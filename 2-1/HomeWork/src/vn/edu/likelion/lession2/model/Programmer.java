package vn.edu.likelion.lession2.model;

public class Programmer extends Employee{
    private int overtimeHour;
    private double hourlyRate;

    /**
     * this is constructor of class
     * @param name
     * @param salary
     * @param overtimeHour
     * @param hourlyRate
     */
    public Programmer(String name, double salary, int overtimeHour, double hourlyRate) {
        super(name, salary);
        this.overtimeHour = overtimeHour;
        this.hourlyRate = hourlyRate;
    }

    /**
     * @return salary of programmer
     */
    @Override
    public double calculateSalary() {
        return getSalary() + (overtimeHour * hourlyRate);
    }

    /**
     * this method is display detail
     */
    @Override
    public void displayInfo() {
        System.out.println("Programmer Name: " + getName());
        System.out.println("Base Salary: $" + getSalary());
        System.out.println("Overtime Hours: " + overtimeHour);
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}
