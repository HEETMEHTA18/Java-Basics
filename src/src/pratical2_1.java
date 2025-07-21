package Basics;

import java.util.*;

class Student {
    String id, name, branch;
    List<Course> courses = new ArrayList<>();

    public Student(String id, String name, String branch) {
        this.id = id;
        this.name = name;
        this.branch = branch;
    }


    class Course {
        String courseName;
        int credits;

        Course(String courseName, int credits) {
            this.courseName = courseName;
            this.credits = credits;
        }

        public String toString() {
            return courseName + " (" + credits + " credits)";
        }
    }

    void addCourse(String courseName, int credits) {
        courses.add(new Course(courseName, credits));
    }

    void enrollSemester(String semesterName) {
        class Semester {
            void showEnrollment() {
                System.out.println("\n " + semesterName + " Enrollment:");
                for (Course c : courses) {
                    System.out.println(" - " + c);
                }
            }
        }
        Semester sem = new Semester();
        sem.showEnrollment();
    }

    void checkScholarshipEligibility(Scholarship s) {
        boolean eligible = s.isEligible(this);
        System.out.println("Scholarship Eligible: " + (eligible ? "Yes" : "No"));
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Branch: " + branch + ", Courses: " + courses;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name);
    }

    public int hashCode() {
        return Objects.hash(id, name);
    }
}

interface Scholarship {
    boolean isEligible(Student s);
}

class practical2_1 {

    public static void main(String[] args) {
        Student s1 = new Student("64", "heet", "CE");
        Student s2 = new Student("65", "om", "ce");

        s1.addCourse("Java", 3);
        s1.addCourse("Python", 4);

        s1.enrollSemester("Semester 1");

        s1.checkScholarshipEligibility(new Scholarship() {
            public boolean isEligible(Student s) {
                return s.courses.size() >= 2;
            }
        });

        System.out.println("\nStudent Info: " + s1);
        System.out.println("s1 equals s2? " + s1.equals(s2));
        System.out.println("HashCode of s1: " + s1.hashCode());

        s2 = null;
        System.gc(); // Suggests garbage collection, but not necessary for most cases
    }
}
