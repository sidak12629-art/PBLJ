import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private static final String FILE = "employees.csv";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Employee Manager ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();
            if (choice.equals("1")) {
                addEmployee(sc);
            } else if (choice.equals("2")) {
                displayEmployees();
            } else if (choice.equals("3")) {
                System.out.println("Exiting. Goodbye!"); break;
            } else {
                System.out.println("Invalid option. Try again."); 
            }
        }
        sc.close();
    }

    private static void addEmployee(Scanner sc) {
        try {
            System.out.print("Enter ID (integer): ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter name: ");
            String name = sc.nextLine().trim();
            System.out.print("Enter department: ");
            String dept = sc.nextLine().trim();
            System.out.print("Enter salary (double): ");
            double sal = Double.parseDouble(sc.nextLine().trim());
            Employee e = new Employee(id, name, dept, sal);

            boolean fileExists = new File(FILE).exists();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) {
                if (!fileExists) {
                    // header (optional)
                    bw.write("id,name,department,salary\n");
                }
                bw.write(e.toString() + "\n");
            }
            System.out.println("Employee added: " + e);
        } catch (Exception ex) {
            System.err.println("Error adding employee: " + ex.getMessage());
        }
    }

    private static void displayEmployees() {
        List<Employee> list = new ArrayList<>();
        File f = new File(FILE);
        if (!f.exists()) {
            System.out.println("No employee records found (" + FILE + "). Add employees first.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line = br.readLine(); // skip header if present
            if (line == null) return;
            // If the first line is header (contains non-numeric first token), skip it
            if (line.matches("^\\D.*")) {
                // header; read next
            } else {
                // Possibly first employee, process it
                Employee e = Employee.fromCsv(line);
                if (e != null) list.add(e);
            }
            while ((line = br.readLine()) != null) {
                Employee e = Employee.fromCsv(line);
                if (e != null) list.add(e);
            }
        } catch (Exception ex) {
            System.err.println("Error reading employees: " + ex.getMessage());
        }

        if (list.isEmpty()) {
            System.out.println("No valid employee records found.");
            return;
        }
        System.out.println("\nEmployees:");
        for (Employee e : list) {
            System.out.println("ID: " + e.getId() + ", Name: " + e.getName() + ", Dept: " + e.getDepartment() + ", Salary: " + e.getSalary());
        }
    }
}
