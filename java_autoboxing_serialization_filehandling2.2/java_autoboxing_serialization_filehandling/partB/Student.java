import java.io.Serializable;

// Simple Student class that is serializable
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int roll;
    private double cgpa;

    public Student(String name, int roll, double cgpa) {
        this.name = name;
        this.roll = roll;
        this.cgpa = cgpa;
    }

    public String getName() { return name; }
    public int getRoll() { return roll; }
    public double getCgpa() { return cgpa; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', roll=" + roll + ", cgpa=" + cgpa + "}";
    }
}
