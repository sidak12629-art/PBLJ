import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return id + "," + name + "," + department + "," + salary;
    }

    // Parse from CSV line
    public static Employee fromCsv(String line) {
        String[] parts = line.split(","); // simple split; names must not contain commas for this example
        if (parts.length < 4) return null;
        try {
            int id = Integer.parseInt(parts[0].trim());
            String name = parts[1].trim();
            String dept = parts[2].trim();
            double sal = Double.parseDouble(parts[3].trim());
            return new Employee(id, name, dept, sal);
        } catch (Exception e) {
            return null;
        }
    }
}
