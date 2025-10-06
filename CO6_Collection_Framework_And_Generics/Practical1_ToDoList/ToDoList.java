import java.util.*;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> displayTasks();
                case 3 -> editTask();
                case 4 -> deleteTask();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter task: ");
        tasks.add(sc.nextLine());
        System.out.println("Task added.");
    }

    static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\n--- Tasks ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    static void editTask() {
        displayTasks();
        System.out.print("Enter task number to edit: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        if (index >= 0 && index < tasks.size()) {
            System.out.print("Enter new task: ");
            tasks.set(index, sc.nextLine());
            System.out.println("Task updated.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    static void deleteTask() {
        displayTasks();
        System.out.print("Enter task number to delete: ");
        int index = sc.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
