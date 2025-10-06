import java.io.*;
import java.util.*;

class Student {
    String name;
    int rollNumber;
    double[] marks;
    double average;
    String grade;
    
    public Student(String name, int rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
        calculateAverage();
        assignGrade();
    }
    
    private void calculateAverage() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        average = sum / marks.length;
    }
    
    private void assignGrade() {
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B+";
        } else if (average >= 60) {
            grade = "B";
        } else if (average >= 50) {
            grade = "C";
        } else if (average >= 40) {
            grade = "D";
        } else {
            grade = "F";
        }
    }
    
    public void displayReport() {
        System.out.println("\n========== GRADE REPORT ==========");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.print("Marks: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i]);
            if (i < marks.length - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Grade: " + grade);
        System.out.println("==================================\n");
    }
    
    public String getReportString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n========== GRADE REPORT ==========\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Roll Number: ").append(rollNumber).append("\n");
        sb.append("Marks: ");
        for (int i = 0; i < marks.length; i++) {
            sb.append(marks[i]);
            if (i < marks.length - 1) sb.append(", ");
        }
        sb.append("\n");
        sb.append(String.format("Average: %.2f\n", average));
        sb.append("Grade: ").append(grade).append("\n");
        sb.append("==================================\n");
        return sb.toString();
    }
}

public class StudentGradeReport {
    
    public static void createSampleInputFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Heet Mehta,101,85,90,88,92,87\n");
            writer.write("Rahul Mehta,102,78,82,80,85,79\n");
            writer.write("Krish Patel,103,92,95,91,94,93\n");
            writer.write("Amit Shaha,104,65,70,68,72,67\n");
            writer.write("Om Mistry,105,55,60,58,62,59\n");
            System.out.println("Sample input file created: " + filename);
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }
    }
    
    public static List<Student> readStudentMarks(String filename) {
        List<Student> students = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Reading student data from: " + filename + "\n");
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int rollNumber = Integer.parseInt(parts[1]);
                double[] marks = new double[parts.length - 2];
                
                for (int i = 2; i < parts.length; i++) {
                    marks[i - 2] = Double.parseDouble(parts[i]);
                }
                
                students.add(new Student(name, rollNumber, marks));
            }
            
            System.out.println("Successfully read " + students.size() + " student records.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return students;
    }
    
    public static void generateReports(List<Student> students, String outputFile) {
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("STUDENT GRADE REPORTS\n");
            writer.write("Generated on: " + new Date() + "\n");
            writer.write("=====================================\n");
            
            for (Student student : students) {
                writer.write(student.getReportString());
                student.displayReport();
            }
            
            System.out.println("\nReports generated successfully!");
            System.out.println("Output file: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Student Grade Report Generator ===\n");
        
        String inputFile = "student_marks.txt";
        String outputFile = "grade_reports.txt";
        
        createSampleInputFile(inputFile);
        System.out.println();
        
        List<Student> students = readStudentMarks(inputFile);
        
        if (!students.isEmpty()) {
            generateReports(students, outputFile);
        }
        
        System.out.println("\n=== Process completed ===");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
