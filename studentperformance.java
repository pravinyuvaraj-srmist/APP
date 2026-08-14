class Student {
    int rollNo;
    String name;
    int[] marks = new int[3];
    double attendance;
    Student(int rollNo, String name, int m1, int m2, int m3, double attendance) {
        this.rollNo = rollNo;
        this.name = name;
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
        this.attendance = attendance;
    }
    void display() {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            total += marks[i];
        }
        double average = total / 3.0;
        String result = (average >= 50) ? "Pass" : "Fail";
        String scholarship =
                (average >= 75 && attendance >= 80) ? "Eligible" : "Not Eligible";
        String performance =
                (average >= 85) ? "Excellent" : "Good";
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Total Marks : " + total);
        System.out.println("Average     : " + average);
        System.out.println("Attendance  : " + attendance + "%");
        System.out.println("Result      : " + result);
        System.out.println("Scholarship : " + scholarship);
        System.out.println("Performance : " + performance);
        System.out.println("--------------------------------");
    }
    double getAverage() {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            total += marks[i];
        }
        return total / 3.0;
    }
}
public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student(101, "Arun", 90, 85, 88, 92);
        students[1] = new Student(102, "Bala", 70, 75, 72, 85);
        students[2] = new Student(103, "Charan", 45, 50, 48, 78);
        students[3] = new Student(104, "David", 95, 92, 90, 95);
        students[4] = new Student(105, "Ezhil", 60, 55, 65, 70);
        System.out.println("===== STUDENT PERFORMANCE REPORT =====");
        for (int i = 0; i < 5; i++) {
            students[i].display();
        }
        Student highest = students[0];
        for (int i = 1; i < 5; i++) {
            highest = (students[i].getAverage() > highest.getAverage())
                    ? students[i]
                    : highest;
        }
        System.out.println("===== HIGHEST AVERAGE =====");
        System.out.println("Roll Number : " + highest.rollNo);
        System.out.println("Name        : " + highest.name);
        System.out.println("Average     : " + highest.getAverage());
    }
}
