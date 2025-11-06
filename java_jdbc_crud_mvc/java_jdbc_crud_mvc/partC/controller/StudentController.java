package controller;
import dao.StudentDAO;
import model.Student;
import view.StudentView;
import java.util.List;

public class StudentController {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        StudentView view = new StudentView();

        while (true) {
            int choice = view.showMenu();
            switch (choice) {
                case 1 -> {
                    Student s = view.getStudentInput();
                    dao.addStudent(s);
                }
                case 2 -> {
                    List<Student> list = dao.getAllStudents();
                    view.displayStudents(list);
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
