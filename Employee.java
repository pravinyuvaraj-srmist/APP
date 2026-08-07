import java.util.Scanner;
class Employee {
    int empId;
    String empName;
    double salary;
    Employee(int id, String name, double sal) {
        empId = id;
        empName = name;
        salary = sal;
    }
    void display() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.println("Salary : " + salary);
    }
}
public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        Employee emp = new Employee(id, name, salary);
        System.out.println("\nEmployee Details");
        emp.display();
        sc.close();
    }
}
