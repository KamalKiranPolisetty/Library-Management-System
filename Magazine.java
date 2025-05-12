package library;

public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String itemName, String itemCode, int issueNumber) {
        super(itemName, itemCode, 7, 0.1); // Magazines have a loan period of 7 days and an overdue fine of $0.1
        this.issueNumber = issueNumber;
    }

    // Getter and Setter for issueNumber...

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String getType() {
        return "Magazine";
    }
    @Override
    public boolean isReferenceItem() {
        return true;
    }
}
