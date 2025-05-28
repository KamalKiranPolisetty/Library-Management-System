package library;

public class Book extends LibraryItem {
    private boolean isBestSeller;
    
    public Book(String itemName, String itemCode, int loanPeriod, double overdueFine, boolean isBestSeller) {
        super(itemName, itemCode, loanPeriod, overdueFine);
        setBorrowable(true);
        this.isBestSeller = isBestSeller;
    }
    
    // Getters and Setters for isBestSeller....

    public boolean isBestSeller() {
        return isBestSeller;
    }

    @Override
    public String getType() {
        return "Book";
    }
    @Override
    public boolean isReferenceItem() {
        return false;
    }
}
