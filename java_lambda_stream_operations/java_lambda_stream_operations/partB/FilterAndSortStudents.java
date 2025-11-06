import java.util.*;
import java.util.stream.*;

public class FilterAndSortStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 82.5),
            new Student("Bob", 68.0),
            new Student("Charlie", 91.0),
            new Student("David", 75.5),
            new Student("Eva", 88.3)
        );

        System.out.println("Students scoring above 75% sorted by marks:");
        List<Student> filtered = students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
                .collect(Collectors.toList());

        filtered.forEach(s -> System.out.println(s.getName() + " - " + s.getMarks() + "%"));
    }
}
