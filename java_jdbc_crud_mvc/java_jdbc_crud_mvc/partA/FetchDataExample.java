import java.sql.*;

public class FetchDataExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String pass = "password";

        String query = "SELECT * FROM employees"; // Example table

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Connected to database. Employee data:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Salary: " + rs.getDouble("salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
