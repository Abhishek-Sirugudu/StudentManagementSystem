package main;

import models.Student;
import services.StudentService;
import Exceptioins.StudentNotFoundException;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static StudentService service = new StudentService();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            try {
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewAllStudents();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        updateStudent();
                        break;
                    case 5:
                        deleteStudent();
                        break;
                    case 6:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (StudentNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    private static void printMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student branch: ");
        String branch = scanner.nextLine();
        
        System.out.print("Enter student marks: ");
        double marks = scanner.nextDouble();
        
        Student student = new Student(id, name, branch, marks);
        service.addStudent(student);
        System.out.println("Student added successfully!");
    }
    
    private static void viewAllStudents() {
        List<Student> students = service.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nList of all students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    
    private static void searchStudent() throws StudentNotFoundException {
        System.out.print("Enter student ID to search: ");
        String id = scanner.nextLine();
        
        Student student = service.getStudentbyId(id);
        System.out.println("Student found: " + student);
    }
    
    private static void updateStudent() throws StudentNotFoundException {
        System.out.print("Enter student ID to update: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter new branch: ");
        String newBranch = scanner.nextLine();
        
        System.out.print("Enter new marks: ");
        double newMarks = scanner.nextDouble();
        
        service.updateStudent(id, newBranch, newMarks);
        System.out.println("Student updated successfully!");
    }
    
    private static void deleteStudent() throws StudentNotFoundException {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();
        
        service.deleteStudent(id);
        System.out.println("Student deleted successfully!");
    }
}