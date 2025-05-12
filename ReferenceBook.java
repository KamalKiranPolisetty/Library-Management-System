package library;

public class ReferenceBook extends LibraryItem {
    private boolean isRestricted;

    public ReferenceBook(String itemName, String itemCode, boolean isRestricted) {
        super(itemName, itemCode, 0, 0); // Reference books have no loan period or overdue fine
        this.isRestricted = isRestricted;
        setBorrowable(false);
    }

    // Getters and Setters for isRestricted...

    public boolean isRestricted() {
        return isRestricted;
    }

    @Override
    public String getType() {
        return "Reference Book";
    }
    @Override
    public boolean isReferenceItem() {
        return true;
    }
}
