import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ExpenseTracker {
    private static final String FILE = "daily_expenses.txt";

    public static void addExpense(String desc, double amount) {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(LocalDate.now() + "," + desc + "," + amount + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showMonthlySummary() {
        Map<String, Double> monthTotals = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String month = parts[0].substring(0, 7); // yyyy-MM
                double amount = Double.parseDouble(parts[2]);
                monthTotals.put(month, monthTotals.getOrDefault(month, 0.0) + amount);
            }
        } catch (IOException e) {
            System.out.println("No data yet.");
        }
        System.out.println("\n--- Monthly Expense Summary ---");
        monthTotals.forEach((m, t) -> System.out.println(m + " : ₹" + t));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Expense\n2. View Summary\n3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 3) break;

            switch (choice) {
                case 1 -> {
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    addExpense(desc, amt);
                    System.out.println("Expense Added!");
                }
                case 2 -> showMonthlySummary();
                default -> System.out.println("Invalid!");
            }
        }
        sc.close();
    }
}
