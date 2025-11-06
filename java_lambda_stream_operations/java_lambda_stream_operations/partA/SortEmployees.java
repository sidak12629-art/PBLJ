import java.util.*;

public class SortEmployees {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 75000),
            new Employee("Bob", 25, 55000),
            new Employee("Charlie", 35, 90000),
            new Employee("David", 28, 60000)
        );

        Scanner sc = new Scanner(System.in);
        System.out.println("Sort employees by: 1-Name 2-Age 3-Salary");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
                break;
            case 2:
                employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
                break;
            case 3:
                employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
                break;
            default:
                System.out.println("Invalid choice, sorting by name as default.");
                employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        }

        System.out.println("\nSorted Employee List:");
        employees.forEach(System.out::println);
        sc.close();
    }
}
