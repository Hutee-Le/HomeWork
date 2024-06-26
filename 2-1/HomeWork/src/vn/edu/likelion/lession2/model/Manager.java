package vn.edu.likelion.lession2.model;

public class Manager extends Employee{
    private double bonus;


    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    /**
     * @return salary of programmer
     */
    @Override
    public double calculateSalary() {
        return getSalary() + bonus;
    }

    /**
     *  this method is display detail of manager
     */
    @Override
    public void displayInfo() {
        System.out.println("Manager Name: " + getName());
        System.out.println("Base Salary: $" + getSalary());
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}
