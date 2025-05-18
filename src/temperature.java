import java.util.Scanner;
import java.util.ArrayList;

public class temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Store days of the week
        ArrayList<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        // Store temperatures
        ArrayList<Double> temperatures = new ArrayList<>();

        System.out.println("Enter the average temperature for each day of the week:");
        for (String day : days) {
            System.out.print(day + ": ");
            double temp = scanner.nextDouble();
            temperatures.add(temp);
        }

        scanner.nextLine(); // consume the leftover newline

        // Allow user to query
        while (true) {
            System.out.println("\nEnter a day of the week to see its temperature, or type 'week' to see all and the weekly average (type 'exit' to quit):");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            } else if (input.equalsIgnoreCase("week")) {
                double total = 0;
                System.out.println("\nTemperatures for the week:");
                for (int i = 0; i < days.size(); i++) {
                    System.out.println(days.get(i) + ": " + temperatures.get(i) + "°");
                    total += temperatures.get(i);
                }
                double average = total / temperatures.size();
                System.out.printf("Weekly average temperature: %.2f°%n", average);
            } else {
                boolean found = false;
                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).equalsIgnoreCase(input)) {
                        System.out.println(days.get(i) + ": " + temperatures.get(i) + "°");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Invalid input. Please enter a valid day (e.g., Monday) or 'week'.");
                }
            }
        }

        scanner.close();
    }
}