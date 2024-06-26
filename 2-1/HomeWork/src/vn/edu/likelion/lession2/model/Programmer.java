package vn.edu.likelion.lession2.model;

public class Programmer extends Employee{
    private int overtimeHour;
    private double hourlyRate;

    public Programmer(String name, double salary, int overtimeHour, double hourlyRate) {
        super(name, salary);
        this.overtimeHour = overtimeHour;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getSalary() + (overtimeHour * hourlyRate);
    }

    @Override
    public void displayInfo() {
        System.out.println("Programmer Name: " + getName());
        System.out.println("Base Salary: $" + getSalary());
        System.out.println("Overtime Hours: " + overtimeHour);
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}
