/*
 * MySQL setup (run this first):
 *
 * CREATE DATABASE IF NOT EXISTS tutorial9;
 * USE tutorial9;
 *
 * CREATE TABLE Book (
 *     BookID INT PRIMARY KEY,
 *     Title VARCHAR(100) NOT NULL,
 *     Author VARCHAR(100) NOT NULL,
 *     Price DECIMAL(8,2) NOT NULL,
 *     Availability VARCHAR(3) NOT NULL DEFAULT 'Yes'   -- 'Yes' / 'No'
 * );
 *
 * Update USER and PASS below, and add the MySQL Connector/J jar to the classpath:
 *   javac BookManager.java
 *   java -cp .:mysql-connector-j-8.x.jar BookManager     (Windows: use ; instead of :)
 */
import java.sql.*;
import java.util.Scanner;

public class BookManager {
    static final String URL  = "jdbc:mysql://localhost:3306/tutorial9";
    static final String USER = "root";
    static final String PASS = "your_password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {
            System.out.println("Connected to MySQL.");
            while (true) {
                System.out.println("\n--- Library Menu ---");
                System.out.println("1. Insert new book");
                System.out.println("2. Search book by ID");
                System.out.println("3. Display all available books");
                System.out.println("4. Issue book (set availability to No)");
                System.out.println("5. Exit");
                System.out.print("Choice: ");
                int ch = Integer.parseInt(sc.nextLine().trim());
                switch (ch) {
                    case 1: insertBook(con, sc); break;
                    case 2: searchBook(con, sc); break;
                    case 3: displayAvailable(con); break;
                    case 4: issueBook(con, sc); break;
                    case 5: System.out.println("Goodbye!"); return;
                    default: System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
        }
    }

    static void insertBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Book ID: ");     int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Title: ");       String title = sc.nextLine();
        System.out.print("Author: ");      String author = sc.nextLine();
        System.out.print("Price: ");       double price = Double.parseDouble(sc.nextLine().trim());
        String sql = "INSERT INTO Book (BookID, Title, Author, Price, Availability) VALUES (?,?,?,?,'Yes')";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id); ps.setString(2, title); ps.setString(3, author); ps.setDouble(4, price);
            System.out.println(ps.executeUpdate() + " book inserted.");
        }
    }

    static void searchBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM Book WHERE BookID = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) printBook(rs); else System.out.println("No book found with ID " + id);
            }
        }
    }

    static void displayAvailable(Connection con) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM Book WHERE Availability = 'Yes'");
             ResultSet rs = ps.executeQuery()) {
            boolean any = false;
            while (rs.next()) { printBook(rs); any = true; }
            if (!any) System.out.println("No books are currently available.");
        }
    }

    static void issueBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID to issue: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        String sql = "UPDATE Book SET Availability = 'No' WHERE BookID = ? AND Availability = 'Yes'";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Book issued. Availability set to No."
                                        : "Book not found or already issued.");
        }
    }

    static void printBook(ResultSet rs) throws SQLException {
        System.out.printf("ID: %d | Title: %s | Author: %s | Price: %.2f | Available: %s%n",
                rs.getInt("BookID"), rs.getString("Title"), rs.getString("Author"),
                rs.getDouble("Price"), rs.getString("Availability"));
    }
}
