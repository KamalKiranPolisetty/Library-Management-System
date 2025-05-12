package library;

public class AudioVideoMaterial extends LibraryItem {
    public AudioVideoMaterial(String itemName, String itemCode, int loanPeriod, double overdueFine) {
        super(itemName, itemCode, loanPeriod, overdueFine);
        setBorrowable(true);
    }

    @Override
    public String getType() {
        return "Audio/Video Material";
    }
    @Override
    public double getOverdueFinePerDay() {
        // Return the overdue fine per day for audio/video materials (e.g., $0.10)
        return 0.10;
    }
    @Override
    public boolean isReferenceItem() {
        return true;
    }
}
