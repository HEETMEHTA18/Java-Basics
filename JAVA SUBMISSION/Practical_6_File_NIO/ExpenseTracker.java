import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class Expense {
    Date date;
    String category;
    double amount;
    String description;
    
    public Expense(Date date, String category, double amount, String description) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }
    
    public String toFileString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date) + "," + category + "," + amount + "," + description;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("%s | %-15s | $%-8.2f | %s", 
                           sdf.format(date), category, amount, description);
    }
}

public class ExpenseTracker {
    private static final String EXPENSE_FILE = "expenses.txt";
    private static List<Expense> expenses = new ArrayList<>();
    
    public static void addExpense(String category, double amount, String description) {
        Expense expense = new Expense(new Date(), category, amount, description);
        expenses.add(expense);
        
        try (FileWriter fw = new FileWriter(EXPENSE_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            out.println(expense.toFileString());
            System.out.println("\n Expense added successfully!");
            System.out.println(expense);
            
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    
    public static void loadExpenses() {
        expenses.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(EXPENSE_FILE))) {
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Date date = sdf.parse(parts[0]);
                    String category = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    String description = parts[3];
                    expenses.add(new Expense(date, category, amount, description));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous expense data found. Starting fresh.");
        } catch (Exception e) {
            System.err.println("Error loading expenses: " + e.getMessage());
        }
    }
    
    public static void displayAllExpenses() {
        System.out.println("\n=== All Expenses ===");
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("Date       | Category        | Amount   | Description");
            System.out.println("----------------------------------------------------------");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }
    
    public static void generateMonthlySummary() {
        System.out.println("\n=== Monthly Summary ===");
        
        if (expenses.isEmpty()) {
            System.out.println("No expenses to summarize.");
            return;
        }
        
        Map<String, Double> categoryTotal = new HashMap<>();
        double totalExpense = 0;
        
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH);
        int currentYear = cal.get(Calendar.YEAR);
        
        for (Expense expense : expenses) {
            cal.setTime(expense.date);
            if (cal.get(Calendar.MONTH) == currentMonth && 
                cal.get(Calendar.YEAR) == currentYear) {
                
                categoryTotal.put(expense.category, 
                    categoryTotal.getOrDefault(expense.category, 0.0) + expense.amount);
                totalExpense += expense.amount;
            }
        }
        
        if (categoryTotal.isEmpty()) {
            System.out.println("No expenses for current month.");
            return;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        System.out.println("Month: " + sdf.format(new Date()));
        System.out.println("\nCategory-wise Breakdown:");
        System.out.println("Category        | Amount");
        System.out.println("---------------------------");
        
        for (Map.Entry<String, Double> entry : categoryTotal.entrySet()) {
            System.out.printf("%-15s | $%.2f\n", entry.getKey(), entry.getValue());
        }
        
        System.out.println("---------------------------");
        System.out.printf("Total Expense   | $%.2f\n", totalExpense);
        
        saveMonthlySummary(categoryTotal, totalExpense);
    }
    
    private static void saveMonthlySummary(Map<String, Double> categoryTotal, double totalExpense) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String summaryFile = "summary_" + sdf.format(new Date()) + ".txt";
        
        try (FileWriter writer = new FileWriter(summaryFile)) {
            SimpleDateFormat fullSdf = new SimpleDateFormat("MMMM yyyy");
            writer.write("MONTHLY EXPENSE SUMMARY\n");
            writer.write("Month: " + fullSdf.format(new Date()) + "\n");
            writer.write("Generated on: " + new Date() + "\n");
            writer.write("=====================================\n\n");
            writer.write("Category-wise Breakdown:\n");
            writer.write("Category        | Amount\n");
            writer.write("---------------------------\n");
            
            for (Map.Entry<String, Double> entry : categoryTotal.entrySet()) {
                writer.write(String.format("%-15s | $%.2f\n", entry.getKey(), entry.getValue()));
            }
            
            writer.write("---------------------------\n");
            writer.write(String.format("Total Expense   | $%.2f\n", totalExpense));
            
            System.out.println("\n Monthly summary saved to: " + summaryFile);
        } catch (IOException e) {
            System.err.println("Error saving summary: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Monthly Expense Tracker ===\n");
        
        loadExpenses();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\n--- Expense Tracker Menu ---");
            System.out.println("1. Add Daily Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Generate Monthly Summary");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Category (Food/Transport/Bills/Shopping/Other): ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Amount: $");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    addExpense(category, amount, description);
                    break;
                case 2:
                    displayAllExpenses();
                    break;
                case 3:
                    generateMonthlySummary();
                    break;
                case 4:
                    running = false;
                    System.out.println("\nThank you for using Expense Tracker!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        }
        
        
        System.out.println("Student: 24CE084 KRISH PATEL");
        scanner.close();
    }
}
