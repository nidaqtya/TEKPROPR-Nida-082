package id.ac.polban.employee.model;

public class Employee {
    private int id;
    private String name;
    private Department department;
    private EmploymentType type;
    private double salary;

    // === STATIC FIELD === 
    // menyimpan jumlah total employee yang dibuat
    private static int totalEmployee = 0;

    public Employee(int id, String name, Department department,
        EmploymentType type, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.type = type;
            this.salary = salary;

            // == Tambah setiap object Employee dibuat ==
            totalEmployee++;
        }

        // ==== STATIC METHOD ===
        // mengambil jumlah total employee
        public static int getTotalEmployee() {
            return totalEmployee;
        }

        // ==== Getter & Setter ====

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Department getDepartment() {
            return department;
        }
        public void setDepartment(Department department) {
            this.department = department;
        }
        public EmploymentType getType() {
            return type;
        }
        public void setType(EmploymentType type) {
            this.type = type;
        }
        public double getSalary() {
            return salary;
        }
        public void setSalary(double salary) {
            this.salary = salary;
        }
}
