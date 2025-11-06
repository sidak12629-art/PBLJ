package dao;
import java.sql.*;
import java.util.*;
import model.Student;

public class StudentDAO {
    private final String URL = "jdbc:mysql://localhost:3306/testdb";
    private final String USER = "root";
    private final String PASS = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void addStudent(Student s) {
        String sql = "INSERT INTO students (id, name, marks) VALUES (?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setDouble(3, s.getMarks());
            ps.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getDouble("marks")));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching students: " + e.getMessage());
        }
        return list;
    }
}
