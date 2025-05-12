package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class User {
    private String name;
    private String address;
    private String phoneNumber;
    private String libraryCardNumber;
    private int age;
    private double balance;
    private boolean isChild;

    public Map<String, LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    private Map<String, LibraryItem> borrowedItems;

    public User(String name, String address, String phoneNumber, String libraryCardNumber, int age, boolean isChild) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.libraryCardNumber = libraryCardNumber;
        this.age = age;
        this.balance = 0.0;
        this.isChild = isChild;
        borrowedItems = new HashMap<>();
        
    }

    public boolean renewItem(String itemCode) {
        LibraryItem item = borrowedItems.get(itemCode);
        if (item != null) {
            if (item.canRenew()) {
                if (item.renew()) {
                    return true;
                } else {
                    System.out.println("Cannot renew " + item.getItemName() + ". Maximum renewals reached.");
                    return false;
                }
            } else {
                System.out.println("Cannot renew " + item.getItemName() + ". Maximum renewals reached.");
                return false;
            }
        } else {
            System.out.println("Item with code " + itemCode + " not found in your borrowed items.");
            return false;
        }
    }
    public void deductBalance(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Deducted $" + amount + " from your account. New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance. Cannot deduct $" + amount + " from your account.");
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public int getAge() {
        return age;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public boolean borrowItem(String itemCode, LibraryItem item) {
        // Existing code...
        if (item != null) {
            item.setBorrowedBy(this);
            borrowedItems.put(itemCode, item); // Add the item to borrowedItems with its due date
            return true;
        }
        return false;
    }
    public boolean returnItem(String itemCode) {
        // Existing code...
        LibraryItem libraryItem = borrowedItems.get(itemCode);
        if (libraryItem != null) {
            libraryItem.setBorrowedBy(null); // Mark the item as not borrowed by any user
            borrowedItems.remove(itemCode); // Remove the item from borrowedItems
            return true;
        }
        return false;
    }

    public double calculateOverdueFine() {
        double totalFine = 0.0;
        LocalDate currentDate = LocalDate.now();
    
        for (LibraryItem item : borrowedItems.values()) {
            LocalDate dueDate = item.getDueDate();
            if (dueDate.isBefore(currentDate)) {
                long daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate);
                double finePerDay = getOverdueFinePerDay(item);
                double fine = finePerDay * daysOverdue;
                totalFine += fine;
            }
        }
    
        return totalFine;
    }

    private double getOverdueFinePerDay(LibraryItem item) {
        if (item instanceof Book) {
            return 0.10; // $0.10 per day for books
        } else if (item instanceof AudioVideoMaterial) {
            return 0.15; // $0.15 per day for audio/video materials
        } else {
            return 0.0; // Default fine per day for unknown item types (e.g., ReferenceBook)
        }
    }
    public boolean isChild() {
        // You can determine if the user is a child based on the user type or any other criteria.
        // For this example, let's assume that users with an age below 12 are considered children.
        return this.isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }
}
