import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LibraryLogger {
    private static final String LOG_FILE = "library_log.txt";

    public static void log(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            fw.write(timestamp + " - " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Issue Book");
            System.out.println("2. Return Book");
            System.out.println("3. View Logs");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 4) break;

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book Name: ");
                    String b1 = sc.nextLine();
                    log("Issued: " + b1);
                    System.out.println("Book Issued!");
                }
                case 2 -> {
                    System.out.print("Enter Book Name: ");
                    String b2 = sc.nextLine();
                    log("Returned: " + b2);
                    System.out.println("Book Returned!");
                }
                case 3 -> {
                    System.out.println("\n=== Library Logs ===");
                    try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE))) {
                        String line;
                        while ((line = br.readLine()) != null)
                            System.out.println(line);
                    } catch (IOException e) {
                        System.out.println("No logs found.");
                    }
                }
                default -> System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
