import java.io.*;
import java.util.*;

public class GradeReport {
    public static void main(String[] args) {
        String inputFile = "student_marks.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                int m1 = Integer.parseInt(data[2]);
                int m2 = Integer.parseInt(data[3]);
                int m3 = Integer.parseInt(data[4]);
                double avg = (m1 + m2 + m3) / 3.0;
                String grade;
                if (avg >= 85) grade = "A";
                else if (avg >= 70) grade = "B";
                else if (avg >= 50) grade = "C";
                else grade = "F";
                System.out.println("ID: " + id + " | Name: " + name +
                                   " | Avg: " + avg + " | Grade: " + grade);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
