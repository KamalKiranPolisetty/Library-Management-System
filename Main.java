package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Scanner scanner = new Scanner(System.in);
        int choice;
        
        while (true) {
            System.out.println("=====----*********** Welcome to Alkek Library System **********------=====");
            System.out.println("1. Student");
            System.out.println("2. Administrator");
            //System.out.println("3. Admin");
            //System.out.println("4. Children");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //performFacultyOperations(library, scanner);
                    performStudentOperations(library, scanner);
                    break;
                case 2:
                    //performStudentOperations(library, scanner);
                    performAdminOperations(library, scanner);
                    break;
                case 3:
                    //performAdminOperations(library, scanner);
                    break;
                case 4:
                    //performChildrenOperations(library, scanner);
                    break;
                case 0:
                    System.out.println("Thank you for visiting library, have a nice day!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static String performFacultyOperations(Library library, Scanner scanner) {
        User faculty1 = library.createUser("f1", "456 Oak St", "555-5678", 20);
        System.out.print("Enter Faculty ID or 0 to create a new ID: ");
        String facultyId = scanner.next();

        while (!facultyId.equals("0") && library.getUserById(facultyId) == null) {
            System.out.println("No such Faculty ID. Please try again or enter 0 to create a new ID.");
            System.out.print("Enter Faculty ID: ");
            facultyId = scanner.next();
        }

        if (facultyId.equals("0")) {
            System.out.print("Enter your name: ");
            String name = scanner.next();
            System.out.print("Enter your address: ");
            String address = scanner.next();
            System.out.print("Enter your phone number: ");
            String phoneNumber = scanner.next();
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            User facultyUser = library.createUser(name, address, phoneNumber, age);
            facultyId = facultyUser.getLibraryCardNumber();
        }
        if (faculty1 != null) {
            System.out.println("Welcome Faculty! Your ID is: " + facultyId);
            library.showFacultyMenu(faculty1);
            
        }
        // Perform faculty operations using the facultyId
        return facultyId;
    }

    private static String performStudentOperations(Library library, Scanner scanner) {
        //User student1 = library.createUser("Smith", "456 Oak St", "555-5678", 20);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID or 0 to create a new library card: ");
        String studentId = sc.next();

        while (!studentId.equals("0") && library.getUserById(studentId) == null) {
            System.out.println("ERROR: Student ID not found. Please try again or enter 0 to create a new ID.");
            System.out.print("Enter Student ID: ");
            studentId = scanner.next();
        }

        User studentUser = null;
        int age = 0;
        if (studentId.equals("0")) {
            System.out.println("Enter your name: ");
            sc.nextLine(); // Consume the leftover newline character
            String name = sc.nextLine();
            System.out.println("Enter your address: ");
            String address = sc.nextLine();
            System.out.println("Enter your phone number: ");
            String phoneNumber = sc.nextLine();
            System.out.println("Enter your age: ");
            age = sc.nextInt();

            studentUser = library.createUser(name, address, phoneNumber, age);
            studentId = studentUser.getLibraryCardNumber();
        }

        if(studentUser == null)
            studentUser = library.getUserById(studentId);

        System.out.println("\nWelcome "+ studentUser.getName() + "! Your library card number is: " + studentId);
        if(age <=12){
            System.out.println("Since your age is less than 12, you are only allowed to borrow upto 5 items.");
        }
        library.showStudentMenu(studentUser);
        
        return studentId;
    }
    
    private static String performChildrenOperations(Library library, Scanner scanner) {
        User child1 = library.createUser("Smith", "456 Oak St", "555-5678", 20);
        System.out.print("Enter Child's ID or 0 to create a new ID: ");
        String childId = scanner.next();

        while (!childId.equals("0") && library.getUserById(childId) == null) {
            System.out.println("No such Child's ID. Please try again or enter 0 to create a new ID.");
            System.out.print("Enter Child's ID: ");
            childId = scanner.next();
        }

        if (childId.equals("0")) {
            System.out.print("Enter child's name: ");
            String name = scanner.next();
            System.out.print("Enter child's address: ");
            String address = scanner.next();
            System.out.print("Enter child's phone number: ");
            String phoneNumber = scanner.next();
            System.out.print("Enter child's age: ");
            int age = scanner.nextInt();

            User childUser = library.createUser(name, address, phoneNumber, age);
            childId = childUser.getLibraryCardNumber();
        }

        if (child1 != null) {
            System.out.println("Welcome Children! Your ID is: " + childId);
            library.showChildrenMenu(child1);
            
        }
        System.out.println("Welcome Child! Your ID is: " + childId);
        return childId;
    }

    private static void performAdminOperations(Library library, Scanner scanner) {
        if (Admin.adminLogin(scanner)) {
            
            Admin.adminMenu(library, scanner);
        } else {
            System.out.println("Invalid admin username or password. Please try again.\n");
        }
    }

    
    
}
