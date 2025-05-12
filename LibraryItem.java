package library;

import java.time.LocalDate;
import java.util.*;
public abstract class LibraryItem {
    private String itemCode;
    private String itemName;
    private int loanPeriod;
    private double overdueFine;
    private LocalDate dueDate;
    private User borrowedBy;
    private boolean available;
    private boolean isBorrowed;
    private int maxRenewals;
    private int renewalsUsed;
    private LocalDate originalDueDate;
    private boolean isReference;
    private boolean borrowable;
    private int renewCount;
    private static final int MAX_RENEWS = 2; 
    private int renewalsLeft;
    
    

    public LibraryItem(String itemName, String itemCode, int loanPeriod, double overdueFine) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.loanPeriod = loanPeriod;
        this.overdueFine = overdueFine;
        this.available = true;
        this.isReference = isReference;
        this.borrowable = true;
        renewCount = 0;
        this.maxRenewals = maxRenewals;
        this.renewalsLeft = 1;
    }
    public boolean isBorrowable() {
        return borrowable;
    }
    public int getMaxRenewals() {
        return maxRenewals;
    }

    public int getRenewalsLeft() {
        return renewalsLeft;
    }
    
    public void setRenewalsLeft(int renewalsLeft) {
        this.renewalsLeft = renewalsLeft;
    }
    public void setBorrowable(boolean borrowable) {
        this.borrowable = borrowable;
    }
    
    double getOverdueFinePerDay(){
        return 0.10;
    }
    // Getters and Setters for itemCode, itemName, loanPeriod, overdueFine...
    public boolean isReference() {
        return isReference;
    }
    
    public abstract boolean isReferenceItem();
    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public double getOverdueFine() {
        return overdueFine;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(User borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public boolean isBorrowed() {
        return borrowedBy != null;
    }
    public abstract String getType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryItem)) return false;
        LibraryItem item = (LibraryItem) o;
        return Objects.equals(itemCode, item.itemCode) && Objects.equals(itemName, item.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemCode, itemName);
    }
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void borrow(User user, LocalDate dueDate, int maxRenewals) {
        this.borrowedBy = user;
        this.dueDate = dueDate;
        this.originalDueDate = dueDate;
        this.isBorrowed = true;
        this.maxRenewals = maxRenewals;
        this.renewalsUsed = 0;
    }

    public boolean canRenew() {
        return renewCount < MAX_RENEWS;
    }

    public boolean renew() {
        LocalDate currentDate = LocalDate.now();
        if (isBorrowed && borrowedBy != null && currentDate.isBefore(dueDate) && renewalsUsed < maxRenewals) {
            // Extend due date by two weeks for books and audio/video materials
            dueDate = dueDate.plusWeeks(2);
            renewalsUsed++;
            System.out.println("Item renewed successfully. New due date: " + dueDate);
        } else if (renewalsUsed >= maxRenewals) {
            System.out.println("You have used all available renewals for this item.");
        } else if (currentDate.isAfter(dueDate)) {
            System.out.println("The due date has passed. Please return the item before renewing.");
        } else {
            System.out.println("You cannot renew this item.");
        }
        if (canRenew()) {
            dueDate = dueDate.plusWeeks(2); // Renew for 2 weeks
            renewCount++;
            return true;
        } else {
            return false;
        }
    }

    
    public void returnItem() {
        this.isBorrowed = false;
        this.borrowedBy = null;
        this.dueDate = null;
        this.renewalsUsed = 0;
        this.originalDueDate = null;
    }
    
}
