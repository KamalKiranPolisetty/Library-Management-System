package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Library {
    private Map<String, User> users;
    private Map<String, LibraryItem> libraryItems;
    private Map<String, LibraryItem> borrowedItems;
    private double overdueFinePerDay;
    private List<BookRequest> bookRequests;
    

    public Library() {
        users = new HashMap<>();
        libraryItems = new HashMap<>();
        borrowedItems = new HashMap<>();
        overdueFinePerDay = 0.10;
        addReferenceBooks();
        bookRequests = new ArrayList<>();
    }

    private void addReferenceBooks() {
       // Non-best sellers
Book b1 = new Book("Introduction to Quantum Mechanics", "PHY001", 14, 0.10, false);
Book b2 = new Book("Digital Design: With an Introduction to the Verilog HDL", "DIG001", 14, 0.10, false);
Book b3 = new Book("Linear Algebra and Its Applications", "MAT001", 14, 0.10, false);
Book b4 = new Book("The Mythical Man-Month", "SWE008", 14, 0.10, false);
Book b5 = new Book("Advanced Engineering Mathematics", "MAT002", 14, 0.10, false);
Book b6 = new Book("Principles of Digital Communication", "COM001", 14, 0.10, false);
Book b7 = new Book( "Domain-Driven Design: Tackling Complexity in the Heart of Software", "SWE009",14, 0.10, false);
Book b8 = new Book("Mechanics of Materials", "ENG001", 14, 0.10, false);
Book b9 = new Book("Thermodynamics: An Engineering Approach", "ENG002", 14, 0.10, false);
Book b10 = new Book("Control Systems Engineering", "ENG003", 14, 1.50, false);

// Audio/Video Materials
AudioVideoMaterial a1 = new AudioVideoMaterial("Planet Earth Movie", "AV001", 0, 0);
AudioVideoMaterial a2 = new AudioVideoMaterial("Animal Kingdom", "AV002", 0, 0);

// Best-sellers
Book book1 = new Book("Introduction to Networking", "NET001", 14, 0.10, true);
Book book2 = new Book("Computer Networking: A Top-Down Approach", "NET002", 14, 0.10, true);
Book book3 = new Book("Data Communications and Networking", "NET003", 14, 0.10, true);
Book book4 = new Book("Network Security Essentials", "NET004", 14, 0.10, true);
Book book5 = new Book("High Performance Browser Networking", "NET005", 14, 0.10, true);
Book book6 = new Book("Software Engineering: A Practitioner's Approach", "SWE001", 14, 0.10, true);
Book book7 = new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "SWE002", 14, 0.10, true);
Book book8 = new Book("The Pragmatic Programmer", "SWE003", 14, 0.10, true);
Book book9 = new Book("Design Patterns: Elements of Reusable Object-Oriented Software", "SWE004", 14, 0.10, true);
Book book10 = new Book("Continuous Delivery: Reliable Software Releases through Build, Test, and Deployment Automation", "SWE005", 14, 0.10, true);
Book book11 = new Book("Refactoring: Improving the Design of Existing Code", "SWE006", 14, 0.10, true);
Book book12 = new Book("Effective Java", "SWE007", 14, 0.10, true);
Book book13 = new Book("Introduction to Algorithms II", "ALG002", 14, 0.10, true);
Book book14 = new Book("Introduction to Machine Learning", "ML001", 14, 0.10, true);
Book book15 = new Book("Introduction to Algorithms I", "ALG001", 14, 0.10, true);
Book book16 = new Book("Encyclopedia of Science", "REF001", 0, 0.0, true);
Book book17 = new Book("Historical Atlas", "REF002", 0, 0.0, true);
Book book18 = new Book("Thesaurus", "REF003", 0, 0.0, true);
Book book19 = new Book("National Geographic Magazine", "MAZ001", 0, 0.0, true);
Book book20 = new Book("Time Magazine", "MAZ002", 0, 0.0, true);
Book book21 = new Book("Forbes Magazine", "MAZ003", 0, 0.0, true);



        libraryItems.put(b1.getItemCode(), b1);
        libraryItems.put(b2.getItemCode(), b2);
        libraryItems.put(b3.getItemCode(), b3);
        libraryItems.put(b4.getItemCode(), b4);
        libraryItems.put(b5.getItemCode(), b5);
        libraryItems.put(b6.getItemCode(), b6);
        libraryItems.put(b7.getItemCode(), b7);
        libraryItems.put(b8.getItemCode(), b8);
        libraryItems.put(b9.getItemCode(), b9);
        libraryItems.put(b10.getItemCode(), b10);

        libraryItems.put(book1.getItemCode(), book1);
        libraryItems.put(book2.getItemCode(), book2);
        libraryItems.put(book3.getItemCode(), book3);
        libraryItems.put(book4.getItemCode(), book4);
        libraryItems.put(book5.getItemCode(), book5);
        libraryItems.put(book6.getItemCode(), book6);
        libraryItems.put(book7.getItemCode(), book7);
        libraryItems.put(book8.getItemCode(), book8);
        libraryItems.put(book9.getItemCode(), book9);
        libraryItems.put(book10.getItemCode(), book10);
        libraryItems.put(book11.getItemCode(), book11);
        libraryItems.put(book12.getItemCode(), book12);
        libraryItems.put(book13.getItemCode(), book13);
        libraryItems.put(book14.getItemCode(), book14);
        libraryItems.put(book15.getItemCode(), book15);
        libraryItems.put(book16.getItemCode(), book16);
        libraryItems.put(book17.getItemCode(), book17);
        libraryItems.put(book18.getItemCode(), book18);
        libraryItems.put(book19.getItemCode(), book19);
        libraryItems.put(book20.getItemCode(), book20);
        libraryItems.put(book21.getItemCode(), book21);

        libraryItems.put(a1.getItemCode(), a1);
        libraryItems.put(a2.getItemCode(), a2);
    }
    
    public User createUser(String name, String address, String phoneNumber, int age) {
        String libraryCardNumber = "A02024-" + (users.size());
        User newUser = new User(name, address, phoneNumber, libraryCardNumber, age, age <= 12);
        users.put(libraryCardNumber, newUser);
        return newUser;
    }

    /*public User createChildUser(String name, String address, String phoneNumber, int age) {
        String libraryCardNumber = "CHILD" + (users.size() + 1);
        User newChild = new User(name, address, phoneNumber, libraryCardNumber, age);
        users.put(libraryCardNumber, newChild);
        return newChild;
    }*/

    public List<BookRequest> getBookRequests() {
        return bookRequests;
    }

    public void raiseBookRequest(User user, LibraryItem item) {
        bookRequests.add(new BookRequest(user, item));
        System.out.println("Request for " + item.getItemName() + " has been raised by " + user.getName());
    }

    public User getUserById(String libraryCardNumber) {
        return users.get(libraryCardNumber);
    }

    public void removeUser(String libraryCardNumber) {
        users.remove(libraryCardNumber);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public void addLibraryItem(LibraryItem item) {
        if (isItemCodeUnique(item.getItemCode()) && isItemNameUnique(item.getItemName())) {
            libraryItems.put(item.getItemCode(), item);
            System.out.println("Item added successfully./n/n");
        } else {
            System.out.println("Item code or item name already exists. Item not added./n/n");
        }
    }

    private boolean isItemCodeUnique(String itemCode) {
        return !libraryItems.containsKey(itemCode);
    }

    private boolean isItemNameUnique(String itemName) {
        for (LibraryItem item : libraryItems.values()) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return false;
            }
        }
        return true;
    }

    public void removeLibraryItem(String itemCode) {
        libraryItems.remove(itemCode);
    }

    public List<LibraryItem> getAllLibraryItems() {
        return new ArrayList<>(libraryItems.values());
    }

    public LibraryItem getLibraryItemByCode(String itemCode) {
        return libraryItems.get(itemCode);
    }

    public boolean borrowItem(User user, String itemCode) {
        Scanner scanner = new Scanner(System.in);
        LibraryItem item = libraryItems.get(itemCode);
        if (item != null && item.isAvailable()) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.isBorrowed()) {
                    System.out.println(book.getItemName() + " is already borrowed by another user.");
                    System.out.print("Do you want to request the item? (yes/no): ");
                    String raiseRequest = scanner.nextLine();
                    if (raiseRequest.equalsIgnoreCase("yes")) {
                        bookRequests.add(new BookRequest(user, book));
                        System.out.println("Your request for " + book.getItemName() + " has been added.");
                    }
                } else {
                    if (book.isBestSeller()) {
                        book.setDueDate(LocalDate.now().plusWeeks(2));
                    } else {
                        book.setDueDate(LocalDate.now().plusWeeks(3));
                    }
                    book.setBorrowedBy(user);
                    book.setRenewalsLeft(1); // Assuming 1 renewal allowed for books
                    System.out.println(book.getItemName() + " is borrowed successfully.");
                }
            } else if (item instanceof AudioVideoMaterial) {
                AudioVideoMaterial avMaterial = (AudioVideoMaterial) item;
                if (avMaterial.isBorrowed()) {
                    System.out.println(avMaterial.getItemName() + " is already borrowed by another user.");
                    System.out.print("Do you want to request the item? (yes/no): ");
                    String raiseRequest = scanner.nextLine();
                    if (raiseRequest.equalsIgnoreCase("yes")) {
                        bookRequests.add(new BookRequest(user, avMaterial));
                        System.out.println("Your request for " + avMaterial.getItemName() + " has been added.");
                    }
                } else {
                    avMaterial.setDueDate(LocalDate.now().plusWeeks(2)); // Two weeks for audio/video materials
                    avMaterial.setBorrowedBy(user);
                    avMaterial.setRenewalsLeft(0); // Assuming 0 renewal allowed for audio/video materials
                    System.out.println(avMaterial.getItemName() + " is borrowed successfully.");
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean returnItem(User user, String itemCode) {
        LibraryItem item = borrowedItems.get(itemCode);
        if (item != null && item.getBorrowedBy() == user) {
            item.setAvailable(true);
            item.setDueDate(null);
            item.setBorrowedBy(null);
            borrowedItems.remove(itemCode);
            return true;
        }
        return false;
    }

    private LocalDate calculateDueDate(LibraryItem item) {
        LocalDate currentDate = LocalDate.now();
        int loanDuration;
        if (item instanceof Book) {
            Book book = (Book) item;
            // Check if it's a current bestseller
            if (book.isBestSeller()) {
                loanDuration = 14; // Two weeks (14 days) for bestsellers
            } else {
                loanDuration = 21; // Three weeks (21 days) for regular books
            }
        } else if (item instanceof AudioVideoMaterial) {
            loanDuration = 14; // Two weeks (14 days) for audio/video materials
        } else {
            loanDuration = 0; // Unknown item type, set to 0 days (due immediately)
        }
        return currentDate.plusDays(loanDuration);
    }

    public void displayAvailableItemsForBorrowing() {
        System.out.println("Available Items for Borrowing:");
        for (LibraryItem item : libraryItems.values()) {
            if (item.isAvailable()) {
                String itemType = "";
                if (item instanceof Book) {
                    itemType = "Book";
                } else if (item instanceof AudioVideoMaterial) {
                    itemType = "Audio/Video Material";
                }
                System.out.println(item.getItemCode() + ": " + item.getItemName() + " (" + itemType + ")");
            }
        }
    }

    

    public void showStudentMenu(User student) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Menu:");
            System.out.println("1- Borrow Items");
            System.out.println("2- Renew Items");
            System.out.println("3- Return Items");
            System.out.println("4. Checkedout items");
            System.out.println("0- Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    borrowItems(student);
                    break;
                case 2:
                    renewItems(student);
                    break;
                case 3:
                    returnItems();
                    break;
                case 4:
                    displayCheckedOutItems(student);
                    break;
                case 0:
                    System.out.println("Exiting Student Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        //scanner.close(); // Close the scanner after use
    }
    public double calculateOverdueFine(LibraryItem item) {
        double fine = 0.0;
        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = item.getDueDate();

        if (item.isBorrowed() && dueDate.isBefore(currentDate)) {
            long daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate);
            double finePerDay = item.getOverdueFinePerDay();
            fine = finePerDay * daysOverdue;
        }

        return fine;
    }
    public void displayCheckedOutItems(User user) {
        System.out.println("Checked-out Items for " + user.getName() + ":");
        int index = 1;
        boolean hasCheckedOutItems = false;
    
        for (LibraryItem item : libraryItems.values()) {
            if (item.isBorrowed() && item.getBorrowedBy().getName().equals(user.getName())) {
                double fine = calculateOverdueFine(item);
                System.out.println(index + ": item code :" + item.getItemCode() + ": item name :" + item.getItemName() + " (Due Date: " + item.getDueDate() + ")" + " Overdue Fine: $" + fine);
                index++;
                hasCheckedOutItems = true;
            }
        }
    
        if (!hasCheckedOutItems) {
            System.out.println("No items are currently checked out.");
        }
    }
    
public void check(User user){
    Scanner scanner = new Scanner(System.in);
    String itemCode;
    while (true) {
        System.out.print("\nEnter the item code to borrow (Enter 0 to stop): ");
        if(user.getAge() <= 12 && user.getBorrowedItems().size() == 5){
            System.out.println("Sorry. You have reached your limit to checkout item. You are only allowed to checkout maximum of 5 items.");
            break;
        }
        itemCode = scanner.nextLine();

        if (itemCode.equals("0")) {
            break;
        }

        LibraryItem item = getLibraryItemByCode(itemCode);
        if (item != null && item.isAvailable()) {
            // Check if the item code starts with "REF" or "MAZ"
            if (itemCode.startsWith("REF") || itemCode.startsWith("MAZ")) {
                System.out.println("Items Reference books and magazines cannot be borrowed.");
            } else {
                if (item.isBorrowable()) {
                    // Borrow the item
                    if (item instanceof Book) {
                        Book book = (Book) item;
                        if (book.isBorrowed()) {
                            System.out.println(book.getItemName() + " is already borrowed by another user.");
                            System.out.print("Do you want to request the item? (yes/no): ");
                            String raiseRequest = scanner.nextLine();
                            if (raiseRequest.equalsIgnoreCase("yes")) {
                                bookRequests.add(new BookRequest(user, book));
                                System.out.println("Your request for " + book.getItemName() + " has been added.");
                            }
                        } else {
                            if (book.isBestSeller()) {
                                book.setDueDate(LocalDate.now().plusWeeks(2));
                            } else {
                                book.setDueDate(LocalDate.now().plusWeeks(3));
                            }
                            book.setBorrowedBy(user);
                            user.borrowItem(book.getItemCode(), item);
                            System.out.println("You have successfully borrowed " +book.getItemName() +
                                    " and due for this item is  :" +book.getDueDate());
                        }
                    } else if (item instanceof AudioVideoMaterial) {
                        AudioVideoMaterial avMaterial = (AudioVideoMaterial) item;
                        if (avMaterial.isBorrowed()) {
                            System.out.println(avMaterial.getItemName() + " is already borrowed by another user.");
                            System.out.print("Do you want to request the item? (yes/no): ");
                            String raiseRequest = scanner.nextLine();
                            if (raiseRequest.equalsIgnoreCase("yes")) {
                                bookRequests.add(new BookRequest(user, avMaterial));
                                System.out.println("Your request for " + avMaterial.getItemName() + " has been added.");
                            }
                        } else {
                            avMaterial.setDueDate(LocalDate.now().plusWeeks(2)); // Two weeks for audio/video materials
                            avMaterial.setBorrowedBy(user);
                            System.out.println(avMaterial.getItemName() + " is borrowed successfully.");
                        }
                    }
                } else {
                    System.out.println(item.getItemName() + " is a reference book and cannot be borrowed.");
                }
            }
        } else {
            System.out.println("Invalid item code or item is not available for borrowing. Please try again.");
            System.out.print("Do you want to raise a request for this item? (yes/no): ");
            String raiseRequest = scanner.nextLine();
            if (raiseRequest.equalsIgnoreCase("yes")) {
                bookRequests.add(new BookRequest(user, item));
                System.out.println("Your request for the item with code " + itemCode + " has been raised.");
            }
        }
    }

    double totalFine = 0.0;
    LocalDate currentDate = LocalDate.now();

    for (LibraryItem item : libraryItems.values()) {
        if (item.isBorrowed() && item.getBorrowedBy() == user) {
            if (item.getDueDate().isBefore(currentDate)) {
                long daysOverdue = ChronoUnit.DAYS.between(item.getDueDate(), currentDate);
                double fine = overdueFinePerDay * daysOverdue;
                totalFine += fine;
            }
        }
    }

    if (totalFine > 0.0) {
        System.out.println("Overdue Fine for " + user.getName() + ": $" + totalFine);
    } else {
        System.out.println("No overdue fine for " + user.getName());
    }
}

    // Borrow items
  public void borrowItems(User user) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nAvailable Items for Borrowing:");
    System.out.println();

    // Convert the values of libraryItems map to a List
    List<LibraryItem> libraryItemList = new ArrayList<>(libraryItems.values());

    // Separate items into different categories
    List<LibraryItem> bestSellers = new ArrayList<>();
    List<LibraryItem> nonBestSellers = new ArrayList<>();
    List<LibraryItem> audioVideoMaterials = new ArrayList<>();

    for (LibraryItem item : libraryItemList) {
        if (item.isAvailable()) {
            if (item instanceof Book) {
                Book temp = (Book) item;
                if (temp.isBestSeller()) {
                    bestSellers.add(item);
                } else {
                    nonBestSellers.add(item);
                }
            } else if (item instanceof AudioVideoMaterial) {
                audioVideoMaterials.add(item);
            }
        }
    }

    // Sort each list by item code
    Comparator<LibraryItem> itemCodeComparator = new Comparator<LibraryItem>() {
        @Override
        public int compare(LibraryItem item1, LibraryItem item2) {
            return item1.getItemCode().compareTo(item2.getItemCode());
        }
    };
    Collections.sort(bestSellers, itemCodeComparator);
    Collections.sort(nonBestSellers, itemCodeComparator);
    Collections.sort(audioVideoMaterials, itemCodeComparator);

    // Display best sellers
    System.out.println("Best Sellers:");
    System.out.println("=============");
    for (LibraryItem item : bestSellers) {
        String itemType = item instanceof Book ? "Book" : "Audio/Video Material";
        Book temp = (Book) item;
        Boolean isBestSeller = temp.isBestSeller();
        System.out.println(item.getItemCode() + ": " + item.getItemName() + " (" + itemType + ") isBestSeller:" + isBestSeller);
    }
    System.out.println(); // Space between different categories

    // Display non-best sellers
    System.out.println("Non-Best Sellers:");
    System.out.println("=================");
    for (LibraryItem item : nonBestSellers) {
        String itemType = item instanceof Book ? "Book" : "Audio/Video Material";
        Book temp = (Book) item;
        Boolean isBestSeller = temp.isBestSeller();
        System.out.println(item.getItemCode() + ": " + item.getItemName() + " (" + itemType + ") isBestSeller:" + isBestSeller);
    }
    System.out.println(); // Space between different categories

    // Display audio/video materials
    System.out.println("Audio/Video Materials:");
    System.out.println("======================");
    for (LibraryItem item : audioVideoMaterials) {
        String itemType = item instanceof Book ? "Book" : "Audio/Video Material";
        System.out.println(item.getItemCode() + ": " + item.getItemName() + " (" + itemType + ")");
    }

    check(user);
    // Ask for item code and borrow items
    // (additional borrowing logic here)
}


    public void displayDueDates() {
        System.out.println("Due Dates for Borrowed Items:");
        for (LibraryItem item : libraryItems.values()) {
            if (item.isBorrowed()) {
                System.out.println(item.getItemName() + ": " + item.getDueDate());
            }
        }
    }
    public void changeDueDate(String itemCode, LocalDate newDueDate) {
        LibraryItem item = libraryItems.get(itemCode);
        if (item != null && item.isBorrowed()) {
            item.setDueDate(newDueDate);
            System.out.println("Due date for " + item.getItemName() + " changed to: " + newDueDate);
        } else {
            System.out.println("Invalid item code or item is not currently borrowed.");
        }
    }
    
    public void renewItems(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRenew Items:");
        List<LibraryItem> checkedOutItems = getCheckedOutItems(user);
        if (checkedOutItems.isEmpty()) {
            System.out.println("You have no items currently checked out.");
        } else {
            System.out.println("Items currently checked out by you:");
            for (LibraryItem item : checkedOutItems) {
                System.out.println("Item code: "+item.getItemCode() +" item name " + ": " + item.getItemName() + " (Due Date: " + item.getDueDate() + ")");
            }

            String itemCode;
            while (true) {
                System.out.print("Enter the item code to renew (Enter 0 to stop): ");
                itemCode = scanner.nextLine();
                if (itemCode.equals("0")) {
                    break;
                }

                LibraryItem item = getLibraryItemByCode(itemCode);
                if (item != null && checkedOutItems.contains(item)) {
                    int renewalsLeft = item.getRenewalsLeft();
                    if (renewalsLeft > 0) {
                        System.out.println("You have " + renewalsLeft + " chance(s) to renew this item.");
                        System.out.print("Do you want to renew this item? (yes/no): ");
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("yes")) {
                            // Renew the item
                            LocalDate newDueDate;
                            if (item instanceof Book) {
                                Book book = (Book) item;
                                if (book.isBestSeller()) {
                                    newDueDate = item.getDueDate().plusWeeks(2);
                                } else {
                                    newDueDate = item.getDueDate().plusWeeks(3);
                                }
                            } else if (item instanceof AudioVideoMaterial) {
                                newDueDate = item.getDueDate().plusWeeks(2);
                            } else {
                                newDueDate = LocalDate.now(); // Unknown item type, set to today (due immediately)
                            }
                            item.setDueDate(newDueDate);
                            item.setRenewalsLeft(renewalsLeft - 1); // Decrease the renewals left
                            System.out.println("Item renewed: " + item.getItemName() + " (New Due Date: " + newDueDate + ")");
                        } else {
                            System.out.println("Renewal cancelled.");
                        }
                    } else {
                        System.out.println("Please return the book. You don't have any renewals available for this item.");
                    }
                } else {
                    System.out.println("Invalid item code or the item is not currently checked out by you.");
                }
            }
        }
    }
    
    public List<LibraryItem> getCheckedOutItems(User user) {
        List<LibraryItem> checkedOutItems = new ArrayList<>();
        for (LibraryItem item : libraryItems.values()) {
            if (item.isBorrowed() && item.getBorrowedBy() == user) {
                checkedOutItems.add(item);
            }
        }
        return checkedOutItems;
    }
    public void returnItems() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("\nEnter the library card number of the student: ");
        String libraryCardNumber = scanner.nextLine();
    
        User student = getUserById(libraryCardNumber);
        if (student == null) {
            System.out.println("Student with library card number " + libraryCardNumber + " not found.");
            return;
        }
    
        List<LibraryItem> checkedOutItems = getCheckedOutItems(student);
        if (checkedOutItems.isEmpty()) {
            System.out.println(student.getName() + " has no items currently checked out.");
            return;
        }
    
        double totalFine = 0.0;
        LocalDate currentDate = LocalDate.now();
    
        for (LibraryItem item : checkedOutItems) {
            if (item.getDueDate() != null && item.getDueDate().isBefore(currentDate)) {
                long daysOverdue = ChronoUnit.DAYS.between(item.getDueDate(), currentDate);
                double fine = overdueFinePerDay * daysOverdue;
                totalFine += fine;
            }
        }
    
        if (totalFine > 0.0) {
            System.out.println("Overdue Fine for " + student.getName() + ": $" + totalFine);
            System.out.print("Do you want to pay the fine? (yes/no): ");
            String payFine = scanner.nextLine();
            if (payFine.equalsIgnoreCase("yes")) {
                student.deductBalance(totalFine);
                System.out.println("Fine paid successfully. Remaining balance: $" + student.getBalance());
            } else {
                System.out.println("Fine not paid. You need to pay the fine before returning the items.");
                return;
            }
        } else {
            System.out.println("No overdue fine for " + student.getName());
        }
    
        System.out.println("\nItems currently checked out by " + student.getName() + ":");
        for (LibraryItem item : checkedOutItems) {
            System.out.println("item code: " + item.getItemCode() + " item name : " + item.getItemName());
        }
    
        System.out.print("\nEnter the item code to return (Enter 0 to stop): ");
        String itemCode;
        while (true) {
            itemCode = scanner.nextLine();
    
            if (itemCode.equals("0")) {
                break;
            }
    
            LibraryItem item = getLibraryItemByCode(itemCode);
            if (item != null && checkedOutItems.contains(item)) {
                item.setBorrowedBy(null); // Mark the item as not borrowed by any user
                checkedOutItems.remove(item);
                System.out.println("You have successfully returned: " + item.getItemName());
            } else {
                System.out.println("Invalid item code or the item is not currently checked out by " + student.getName() + ". Please try again.");
            }
    
            System.out.print("\nEnter the item code to return (Enter 0 to stop): ");
        }
    }
    
        
    
    
    
    public void showFacultyMenu(User faculty) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the faculty menu options
            System.out.println("\nFaculty Menu:");
            System.out.println("1. Borrow Items");
            System.out.println("2. Renew Items");
            System.out.println("3. Return Items");
            System.out.println("4. Checkedout items");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            // Validate input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left in the input buffer

            switch (choice) {
                case 1:
                    borrowItems(faculty);
                    break;
                case 2:
                    renewItems(faculty);
                    break;
                case 3:
                    returnItems();
                    break;
                case 4:
                    displayCheckedOutItems(faculty);
                    break;
                case 0:
                    System.out.println("Exiting Student Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public void showChildrenMenu(User child) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the children menu options
            System.out.println("\nChildren Menu:");
            System.out.println("1. Borrow Items");
            System.out.println("2. Renew Items");
            System.out.println("3. Return Items()");
            System.out.println("4. Checkedout items");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            // Validate input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left in the input buffer

            switch (choice) {
                case 1:
                    borrowItems(child);
                    break;
                case 2:
                    renewItems(child);
                    break;
                case 3:
                    returnItems();
                    break;
                case 4:
                    displayCheckedOutItems(child);
                    break;
                case 0:
                    System.out.println("Exiting Student Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    // Other methods in the Library class...
}
