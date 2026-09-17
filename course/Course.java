package course;

public class Course {
    private int courseId;
    private String courseName;
    private int duration;

    public Course(int courseId, String courseName, int duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourse() {
        System.out.println("----- Course Details -----");
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " years");
    }
}
