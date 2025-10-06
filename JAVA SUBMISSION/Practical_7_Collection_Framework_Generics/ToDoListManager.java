import java.util.*;

class Task {
    private int id;
    private String description;
    private boolean isCompleted;
    
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.isCompleted = false;
    }
    
    public int getId() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isCompleted() {
        return isCompleted;
    }
    
    public void markAsCompleted() {
        this.isCompleted = true;
    }
    
    @Override
    public String toString() {
        String status = isCompleted ? "[✓]" : "[ ]";
        return String.format("%s Task %d: %s", status, id, description);
    }
}

public class ToDoListManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void addTask() {
        System.out.print("\nEnter task description: ");
        String description = scanner.nextLine();
        
        Task newTask = new Task(nextId++, description);
        tasks.add(newTask);
        
        System.out.println(" Task added successfully!");
        System.out.println(newTask);
    }
    
    public static void displayAllTasks() {
        System.out.println("\n=== All Tasks ===");
        
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
            return;
        }
        
        for (Task task : tasks) {
            System.out.println(task);
        }
        
        System.out.println("\nTotal tasks: " + tasks.size());
    }
    
    public static void editTask() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks to edit.");
            return;
        }
        
        displayAllTasks();
        System.out.print("\nEnter task ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Task task = findTaskById(id);
        
        if (task != null) {
            System.out.println("Current description: " + task.getDescription());
            System.out.print("Enter new description: ");
            String newDescription = scanner.nextLine();
            
            task.setDescription(newDescription);
            System.out.println("MTask updated successfully!");
            System.out.println(task);
        } else {
            System.out.println(" Task not found with ID: " + id);
        }
    }
    
    public static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks to delete.");
            return;
        }
        
        displayAllTasks();
        System.out.print("\nEnter task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Task task = findTaskById(id);
        
        if (task != null) {
            tasks.remove(task);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println(" Task not found with ID: " + id);
        }
    }
    
    public static void markTaskAsCompleted() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks to mark as completed.");
            return;
        }
        
        displayAllTasks();
        System.out.print("\nEnter task ID to mark as completed: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Task task = findTaskById(id);
        
        if (task != null) {
            task.markAsCompleted();
            System.out.println(" Task marked as completed!");
            System.out.println(task);
        } else {
            System.out.println(" Task not found with ID: " + id);
        }
    }
    
    private static Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    
    public static void displayMenu() {
        System.out.println("\n===== To-Do List Manager =====");
        System.out.println("1. Add a new task");
        System.out.println("2. Display all tasks");
        System.out.println("3. Edit an existing task");
        System.out.println("4. Delete a task");
        System.out.println("5. Mark task as completed");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        System.out.println("===== Welcome to To-Do List Manager =====");
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    displayAllTasks();
                    break;
                case 3:
                    editTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    markTaskAsCompleted();
                    break;
                case 6:
                    running = false;
                    System.out.println("\nThank you for using To-Do List Manager!");
                    break;
                default:
                    System.out.println("\n Invalid choice! Please try again.");
            }
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
        
        scanner.close();
    }
}