package student;

public class Student {
    private int rollNo;
    private String name;
    private String department;

    public Student(int rollNo, String name, String department) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
    }

    public void displayStudent() {
        System.out.println("----- Student Details -----");
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}
