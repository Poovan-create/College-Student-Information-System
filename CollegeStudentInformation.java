package college;

import java.util.Scanner;

// Course class
class Course {
    String courseName;
    Integer marks; // Wrapper class

    // Constructor
    Course(String courseName, Integer marks) {
        this.courseName = courseName;
        this.marks = marks;
    }
}

// Student class
class Student {
    int rollNo;
    String name;
    Course[] courses;

    // Constructor
    Student(int rollNo, String name, Course[] courses) {
        this.rollNo = rollNo;
        this.name = name;
        this.courses = courses;
    }

    // Calculate total marks
    int calculateTotal() {
        int total = 0;

        for (Course c : courses) {
            total += c.marks;
        }

        return total;
    }

    // Calculate average
    double calculateAverage() {
        return (double) calculateTotal() / courses.length;
    }

    // Calculate grade
    char calculateGrade() {
        double average = calculateAverage();

        if (average >= 90)
            return 'A';
        else if (average >= 75)
            return 'B';
        else if (average >= 60)
            return 'C';
        else if (average >= 50)
            return 'D';
        else
            return 'F';
    }

    // Display student details
    void display() {
        System.out.println("\n--- Student Information ---");
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);

        System.out.println("\nCourse Details:");

        for (Course c : courses) {
            System.out.println(c.courseName + " : " + c.marks);
        }

        System.out.println("\nTotal Marks: " + calculateTotal());
        System.out.println("Average: " + calculateAverage());
        System.out.println("Grade: " + calculateGrade());
    }
}

// Main class
public class CollegeStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("COLLEGE STUDENT INFORMATION SYSTEM");

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Number of Courses: ");
        int n = sc.nextInt();
        sc.nextLine();

        Course[] courses = new Course[n];

        // Input course details
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Course Name: ");
            String courseName = sc.nextLine();

            System.out.print("Enter Marks: ");
            Integer marks = sc.nextInt();
            sc.nextLine();

            courses[i] = new Course(courseName, marks);
        }

        // Create student object
        Student s = new Student(rollNo, name, courses);

        // Display student details
        s.display();

        sc.close();
    }
}
