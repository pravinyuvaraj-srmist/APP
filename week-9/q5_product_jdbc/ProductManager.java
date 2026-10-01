import java.sql.*;
import java.util.Scanner;

public class ProductManager {
    static final String URL  = "jdbc:mysql://localhost:3306/tutorial9";
    static final String USER = "root";
    static final String PASS = "your_password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {
            System.out.println("Connected to MySQL.");
            while (true) {
                System.out.println("\n--- Product Menu ---");
                System.out.println("1. Insert new product");
                System.out.println("2. Retrieve product by ID");
                System.out.println("3. Update product quantity");
                System.out.println("4. Display products with quantity below 10");
                System.out.println("5. Exit");
                System.out.print("Choice: ");
                int ch = Integer.parseInt(sc.nextLine().trim());
                switch (ch) {
                    case 1: insert(con, sc); break;
                    case 2: retrieve(con, sc); break;
                    case 3: updateQty(con, sc); break;
                    case 4: lowStock(con); break;
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

    static void insert(Connection con, Scanner sc) throws SQLException {
        System.out.print("Product ID: ");   int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Product Name: "); String name = sc.nextLine();
        System.out.print("Price: ");        double price = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Quantity: ");     int qty = Integer.parseInt(sc.nextLine().trim());
        try (PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Product (ProductID, ProductName, Price, Quantity) VALUES (?,?,?,?)")) {
            ps.setInt(1, id); ps.setString(2, name); ps.setDouble(3, price); ps.setInt(4, qty);
            System.out.println(ps.executeUpdate() + " product inserted.");
        }
    }

    static void retrieve(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Product ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM Product WHERE ProductID = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) print(rs); else System.out.println("No product found with ID " + id);
            }
        }
    }

    static void updateQty(Connection con, Scanner sc) throws SQLException {
        System.out.print("Product ID: ");    int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("New Quantity: ");  int qty = Integer.parseInt(sc.nextLine().trim());
        try (PreparedStatement ps = con.prepareStatement("UPDATE Product SET Quantity = ? WHERE ProductID = ?")) {
            ps.setInt(1, qty); ps.setInt(2, id);
            System.out.println(ps.executeUpdate() > 0 ? "Quantity updated." : "Product not found.");
        }
    }

    static void lowStock(Connection con) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM Product WHERE Quantity < ?")) {
            ps.setInt(1, 10);
            try (ResultSet rs = ps.executeQuery()) {
                boolean any = false;
                while (rs.next()) { print(rs); any = true; }
                if (!any) System.out.println("No products with quantity below 10.");
            }
        }
    }

    static void print(ResultSet rs) throws SQLException {
        System.out.printf("ID: %d | Name: %s | Price: %.2f | Quantity: %d%n",
                rs.getInt("ProductID"), rs.getString("ProductName"),
                rs.getDouble("Price"), rs.getInt("Quantity"));
    }
}
