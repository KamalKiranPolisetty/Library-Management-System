package library;

public class BookRequest {
    private User user;
    private LibraryItem item;

    public BookRequest(User user, LibraryItem item) {
        this.user = user;
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public LibraryItem getItem() {
        return item;
    }
}
