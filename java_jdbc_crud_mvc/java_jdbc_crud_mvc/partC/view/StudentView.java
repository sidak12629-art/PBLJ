package view;
import java.util.List;
import java.util.Scanner;
import model.Student;

public class StudentView {
    private Scanner sc = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n--- Student Management Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(sc.nextLine());
    }

    public Student getStudentInput() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = Double.parseDouble(sc.nextLine());
        return new Student(id, name, marks);
    }

    public void displayStudents(List<Student> list) {
        System.out.println("\n--- Student List ---");
        list.forEach(System.out::println);
    }
}
