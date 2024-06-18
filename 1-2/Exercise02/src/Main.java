public class Main {
    public static void main(String[] args){
        Employee employee = new Employee();
        employee.work();
        employee.getSalary();

        Employee hr = new HRManager();
        hr.work();
        hr.getSalary();
        hr.addEmployee();
    }
}
