import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoboxingSum {
    // Demonstrates autoboxing/unboxing and parsing strings to integers
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers separated by spaces (or press Enter for default example):");
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            line = "10 20 30 -5 0"; // default example
            System.out.println("Using default input: " + line);
        }

        String[] tokens = line.split("\\s+"); // split on whitespace
        List<Integer> list = new ArrayList<>();

        // Parse strings into int (Integer.parseInt) and use autoboxing to add to List<Integer>
        for (String t : tokens) {
            try {
                int val = Integer.parseInt(t); // parse string to primitive int
                list.add(val); // autoboxing: primitive int -> Integer
            } catch (NumberFormatException e) {
                System.err.println("Skipping invalid integer token: '" + t + "'"); 
            }
        }

        // Sum using unboxing (Integer -> int automatically)
        int sum = 0;
        for (Integer x : list) {
            sum += x; // unboxing happens here
        }

        System.out.println("Numbers parsed: " + list);
        System.out.println("Sum (using autoboxing/unboxing): " + sum);
        sc.close();
    }
}
