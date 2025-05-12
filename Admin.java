package library;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private static final String ADMIN_USERNAME = "user";
    private static final String ADMIN_PASSWORD = "pass";
    
    public static boolean adminLogin(Scanner scanner) {
        System.out.print("Enter admin username: ");
        String enteredUsername = scanner.next();
        System.out.print("Enter admin password: ");
        String enteredPassword = scanner.next();

        return enteredUsername.equals(ADMIN_USERNAME) && enteredPassword.equals(ADMIN_PASSWORD);
    }

    public static void adminMenu(Library library, Scanner scanner) {
        int adminChoice;

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            //System.out.println("3. Add faculty");
            //System.out.println("4. Remove faculty");
            //System.out.println("5. Add child");
            //System.out.println("6. Remove child");
            System.out.println("3. Add library item");
            System.out.println("4. Remove library item");
            System.out.println("5. View all library items");
            System.out.println("6. View all members");
            System.out.println("7. Display book requests");
            System.out.println("8. Change due date of an item");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    addStudent(library, scanner);
                    break;
                case 2:
                    removeStudent(library, scanner);
                    break;
                case 3:
                    //addFaculty(library, scanner);
                    addLibraryItem(library, scanner);
                    break;
                case 4:
                    //removeFaculty(library, scanner);
                    removeLibraryItem(library, scanner);
                    break;
                case 5:
                    //addChild(library, scanner);
                    viewAllLibraryItems(library);
                    break;
                case 6:
                    //removeChild(library, scanner);
                    viewAllMembers(library);
                    break;
                case 7:
                    //addLibraryItem(library, scanner);
                    displayAllRequests(library.getBookRequests());
                    break;
                case 8:
                    changeDueDate(library, scanner);
                    //removeLibraryItem(library, scanner);
                    break;
                case 9:
                    //viewAllLibraryItems(library);
                    break;
                case 10:
                    //viewAllMembers(library);
                    break;
                case 11:
                    //changeDueDate(library, scanner);
                    break;
                case 12:
                    //displayAllRequests(library.getBookRequests());
                    break;
                case 0:
                    System.out.println("Exiting Admin Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void changeDueDate(Library library, Scanner scanner) {
        System.out.print("\nEnter the item code for which you want to change the due date (Enter 0 to stop): ");
    String itemCode;
    while (true) {
        itemCode = scanner.nextLine();

        if (itemCode.equals("0")) {
            break;
        }

        LibraryItem item = library.getLibraryItemByCode(itemCode);
        if (item != null) {
            System.out.println("Current Due Date for " + item.getItemName() + ": " + item.getDueDate());

            System.out.print("Enter the new due date (yyyy-MM-dd): ");
            String newDueDateStr = scanner.nextLine();

            try {
                LocalDate newDueDate = LocalDate.parse(newDueDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                item.setDueDate(newDueDate);
                System.out.println("Due date for " + item.getItemName() + " changed to: " + item.getDueDate());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
            }
        } else {
            System.out.println("Invalid item code. Please try again.");
        }

        System.out.print("\nEnter the item code for which you want to change the due date (Enter 0 to stop): ");
    }
    }

     public static void displayAllRequests(List<BookRequest> bookRequests) {
        System.out.println("\n===== All Book Requests =====");
        if (bookRequests.isEmpty()) {
            System.out.println("No book requests raised.");
        } else {
            for (BookRequest request : bookRequests) {
                System.out.println("User: " + request.getUser().getName() +
                        " - Item Code: " + request.getItem().getItemCode() +
                        " - Item Name: " + request.getItem().getItemName());
            }
        }
        System.out.println("=============================\n");
    }

    public static void addStudent(Library library, Scanner scanner) {
        System.out.print("Enter student's name: ");
        String name = scanner.next();
        System.out.print("Enter student's address: ");
        String address = scanner.next();
        System.out.print("Enter student's phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter student's age: ");
        int age = scanner.nextInt();

        User student = library.createUser(name, address, phoneNumber, age);
        System.out.println("Student added successfully. Student ID: " + student.getLibraryCardNumber());
    }

    public static void removeStudent(Library library, Scanner scanner) {
        System.out.print("Enter student ID to remove: ");
        String studentId = scanner.next();

        User student = library.getUserById(studentId);
        if (student != null) {
            library.removeUser(studentId);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("No student found with ID: " + studentId);
        }
    }

    public static void addFaculty(Library library, Scanner scanner) {
        System.out.print("Enter faculty's name: ");
        String name = scanner.next();
        System.out.print("Enter faculty's address: ");
        String address = scanner.next();
        System.out.print("Enter faculty's phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter faculty's age: ");
        int age = scanner.nextInt();

        User faculty = library.createUser(name, address, phoneNumber, age);
        System.out.println("Faculty added successfully. Faculty ID: " + faculty.getLibraryCardNumber());
    }

    public static void removeFaculty(Library library, Scanner scanner) {
        System.out.print("Enter faculty ID to remove: ");
        String facultyId = scanner.next();

        User faculty = library.getUserById(facultyId);
        if (faculty != null) {
            library.removeUser(facultyId);
            System.out.println("Faculty removed successfully.");
        } else {
            System.out.println("No faculty found with ID: " + facultyId);
        }
    }

    /*public static void addChild(Library library, Scanner scanner) {
        System.out.print("Enter child's name: ");
        String name = scanner.next();
        System.out.print("Enter child's address: ");
        String address = scanner.next();
        System.out.print("Enter child's phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter child's age: ");
        int age = scanner.nextInt();

        User child = library.createChildUser(name, address, phoneNumber, age);
        System.out.println("Child added successfully. Child ID: " + child.getLibraryCardNumber());
    }*/

    public static void removeChild(Library library, Scanner scanner) {
        System.out.print("Enter child ID to remove: ");
        String childId = scanner.next();

        User child = library.getUserById(childId);
        if (child != null) {
            library.removeUser(childId);
            System.out.println("Child removed successfully.");
        } else {
            System.out.println("No child found with ID: " + childId);
        }
    }

    public static void addLibraryItem(Library library, Scanner scanner) {
        System.out.print("Enter item code: ");
        String itemCode = scanner.next();
        System.out.print("Enter item name: ");
        String itemName = scanner.next();
        System.out.print("Is it a book? (true/false): ");
        boolean isBook = scanner.nextBoolean();

        LibraryItem newItem;
        if (isBook) {
            System.out.print("Is it a best seller? (true/false): ");
            boolean isBestSeller = scanner.nextBoolean();
            int loanPeriod = isBestSeller ? 14 : 21;
            newItem = new Book(itemName, itemCode, loanPeriod, 0.1, isBestSeller);
        } else {
            newItem = new AudioVideoMaterial(itemName, itemCode, 14, 0.1);
        }

        library.addLibraryItem(newItem);
        //System.out.println("Item added successfully.");
    }

    public static void removeLibraryItem(Library library, Scanner scanner) {
        System.out.print("Enter item code to remove: ");
        String itemCode = scanner.next();

        LibraryItem item = library.getLibraryItemByCode(itemCode);
        if (item != null) {
            library.removeLibraryItem(itemCode);
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("No item found with code: " + itemCode);
        }
    }

    public static void viewAllLibraryItems(Library library) {
        System.out.println("\n===== All Library Items =====");
        for (LibraryItem item : library.getAllLibraryItems()) {
            System.out.println("Item Code: " + item.getItemCode() + " - Item Name: " + item.getItemName() + " - Type: " + item.getType());
        }
        System.out.println("=============================\n");
    }
public static void viewAllMembers(Library library) {
        System.out.println("\n===== All Members =====");
        for (User user : library.getAllUsers()) {
            System.out.println("Name: " + user.getName());
            System.out.println("Address: " + user.getAddress());
            System.out.println("Phone Number: " + user.getPhoneNumber());
            System.out.println("Library Card Number: " + user.getLibraryCardNumber());
            System.out.println("Age: " + user.getAge());

            if (user instanceof ChildUser) {
                System.out.println("Member Type: Child");
            } else if (user instanceof FacultyUser) {
                System.out.println("Member Type: Faculty");
            } else {
                System.out.println("Member Type: Student");
            }

            System.out.println();
            System.out.println("Checkout items :: "+ user.getBorrowedItems().size());
            int index = 1;
            double fine = 0.0;
            for (LibraryItem item : user.getBorrowedItems().values()){
                //double fine = calculateOverdueFine(item);
                LocalDate currentDate = LocalDate.now();
                LocalDate dueDate = item.getDueDate();
                long daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate);
                double finePerDay = item.getOverdueFinePerDay();
                fine = finePerDay * daysOverdue;
                String formattedValue = String.format("%.2f", fine);
                System.out.println(index + ": item code :" + item.getItemCode() + ": item name :" + item.getItemName() + " (Due Date: " + item.getDueDate() + ")" + " Overdue Fine: $" + formattedValue);
                index++;
            }
        }
        System.out.println("========================\n");
    }
}

class ChildUser extends User {
    public ChildUser(String name, String address, String phoneNumber, String libraryCardNumber, int age) {
        super(name, address, phoneNumber, libraryCardNumber, age, true);
    }
}

class FacultyUser extends User {
    public FacultyUser(String name, String address, String phoneNumber, String libraryCardNumber, int age) {
        super(name, address, phoneNumber, libraryCardNumber, age, false);
    }
}

class StudentUser extends User {
    public StudentUser(String name, String address, String phoneNumber, String libraryCardNumber, int age) {
        super(name, address, phoneNumber, libraryCardNumber, age, false);
    }
}



