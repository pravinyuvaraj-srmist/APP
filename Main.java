import student.Student;
import course.Course;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(101, "Arun", "Computer Science");
        Course course = new Course(501, "Java Programming", 4);

        student.displayStudent();
        System.out.println();
        course.displayCourse();
    }
}
