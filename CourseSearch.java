import java.sql.*;
import java.util.Scanner;

public class CourseSearch {
    static final String URL  = "jdbc:mysql://localhost:3306/tutorial9";
    static final String USER = "root";
    static final String PASS = "your_password";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Course Code: ");
            String code = sc.nextLine().trim();

            String sql = "SELECT StudentID, StudentName, CourseCode, CourseName, Semester "
                       + "FROM CourseRegistration WHERE CourseCode = ?";
            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, code);
                try (ResultSet rs = ps.executeQuery()) {
                    boolean found = false;
                    while (rs.next()) {
                        if (!found) System.out.println("\nStudents registered for " + code + ":");
                        found = true;
                        System.out.printf("ID: %d | Name: %s | Course: %s (%s) | Semester: %d%n",
                                rs.getInt("StudentID"), rs.getString("StudentName"),
                                rs.getString("CourseName"), rs.getString("CourseCode"),
                                rs.getInt("Semester"));
                    }
                    if (!found) System.out.println("No students are registered for course code " + code);
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }
}
