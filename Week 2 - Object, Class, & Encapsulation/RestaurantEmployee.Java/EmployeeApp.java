import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class EmployeeApp {
    public static void main(String[] args) {

        Department it = new Department("IT");
        EmploymentType fullTime = new EmploymentType("Full-Time");

        Employee emp1 = new Employee(1, "Nida", it, fullTime, 5000000);

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);

        System.out.println("Nama: " + service.getEmployee(1).getName());

        System.out.println("Department: " + service.getEmployee(1).getDepartment().getName());

        System.out.println("Gaji sebelum kenaikan: " + service.getEmployee(1).getSalary());

        service.raiseSalary(1, 10);

        System.out.println("Gaji setelah kenaikan: " + service.getEmployee(1).getSalary());

        System.out.println("Total Employee: " + Employee.getTotalEmployee());
    }
}