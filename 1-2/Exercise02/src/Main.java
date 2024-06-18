public class Main {
    public static void main(String[] args){
        Employee employee = new Employee();
        employee.work();
        employee.getSalary();

        Employee hrManager = new HRManager();
        hrManager.work();
        hrManager.getSalary();
        ((HRManager) hrManager).addEmployee();
    }
}
