import java.sql.*;
import java.util.Scanner;

public class ProductCRUD {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {
            con.setAutoCommit(false);

            while (true) {
                System.out.println("\n--- Product CRUD Menu ---");
                System.out.println("1. Create Product");
                System.out.println("2. Read Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> createProduct(con, sc);
                    case 2 -> readProducts(con);
                    case 3 -> updateProduct(con, sc);
                    case 4 -> deleteProduct(con, sc);
                    case 5 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createProduct(Connection con, Scanner sc) {
        try {
            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Price: ");
            double price = Double.parseDouble(sc.nextLine());

            String sql = "INSERT INTO product (name, price) VALUES (?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setDouble(2, price);
                ps.executeUpdate();
                con.commit();
                System.out.println("Product added successfully.");
            }
        } catch (Exception e) {
            try { con.rollback(); } catch (SQLException ignored) {}
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void readProducts(Connection con) {
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM product")) {
            System.out.println("\nProduct List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name")
                        + ", Price: " + rs.getDouble("price"));
            }
        } catch (Exception e) {
            System.out.println("Error reading products: " + e.getMessage());
        }
    }

    private static void updateProduct(Connection con, Scanner sc) {
        try {
            System.out.print("Enter Product ID to update: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new price: ");
            double price = Double.parseDouble(sc.nextLine());

            String sql = "UPDATE product SET name=?, price=? WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setDouble(2, price);
                ps.setInt(3, id);
                int rows = ps.executeUpdate();
                con.commit();
                System.out.println(rows + " record(s) updated.");
            }
        } catch (Exception e) {
            try { con.rollback(); } catch (SQLException ignored) {}
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

    private static void deleteProduct(Connection con, Scanner sc) {
        try {
            System.out.print("Enter Product ID to delete: ");
            int id = Integer.parseInt(sc.nextLine());
            String sql = "DELETE FROM product WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                con.commit();
                System.out.println(rows + " record(s) deleted.");
            }
        } catch (Exception e) {
            try { con.rollback(); } catch (SQLException ignored) {}
            System.out.println("Error deleting product: " + e.getMessage());
        }
    }
}
