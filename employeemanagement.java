class Employee {
    int employeeId;
    String name;
    double monthlySalary;
    Employee(int employeeId, String name, double monthlySalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }
    void displayDetails() {
        System.out.println("Employee ID     : " + employeeId);
        System.out.println("Name            : " + name);
        System.out.println("Monthly Salary  : ₹" + monthlySalary);
    }
    double calculateAnnualSalary() {
        return monthlySalary * 12;
    }
    double calculateBonus() {
        double annualSalary = calculateAnnualSalary();
        if (monthlySalary >= 30000) {
            return annualSalary * 0.10;
        } else {
            return 0;
        }
    }
    String checkEligibility() {
        return (monthlySalary >= 30000) ? "Eligible" : "Not Eligible";
    }
    void display() {
        displayDetails();
        System.out.println("Annual Salary   : ₹" + calculateAnnualSalary());
        System.out.println("Bonus           : ₹" + calculateBonus());
        System.out.println("Bonus Eligibility: " + checkEligibility());
        System.out.println("----------------------------------");
    }
}
public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee(101, "Arun", 35000);
        employees[1] = new Employee(102, "Bala", 28000);
        employees[2] = new Employee(103, "Charan", 45000);
        employees[3] = new Employee(104, "David", 25000);
        employees[4] = new Employee(105, "Ezhil", 30000);
        System.out.println("===== EMPLOYEE MANAGEMENT SYSTEM =====");
        for (int i = 0; i < 5; i++) {
            employees[i].display();
        }
    }
}
