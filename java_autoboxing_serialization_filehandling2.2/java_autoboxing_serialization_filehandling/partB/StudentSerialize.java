import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class StudentSerialize {
    private static final String FILE = "student.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter roll (integer): ");
        int roll = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter CGPA (double): ");
        double cgpa = Double.parseDouble(sc.nextLine().trim());

        Student s = new Student(name, roll, cgpa);
        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(s);
            System.out.println("Student object serialized to file: " + FILE);
        } catch (Exception e) {
            System.err.println("Error during serialization: " + e.getMessage());
            e.printStackTrace();
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof Student) {
                Student s2 = (Student) obj;
                System.out.println("Student object deserialized: " + s2);
            } else {
                System.err.println("File does not contain a Student object."); 
            }
        } catch (Exception e) {
            System.err.println("Error during deserialization: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}
