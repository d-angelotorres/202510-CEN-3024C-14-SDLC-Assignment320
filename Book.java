import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isCheckedOut;
    private Date dueDate;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isCheckedOut = false; // Initially, all books are checked in
        this.dueDate = null;       // No due date when checked in
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void checkOut() {
        if (!isCheckedOut) {
            isCheckedOut = true;
            dueDate = new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 7 * 4)); // 4 weeks from today
        } else {
            System.out.println("Book is already checked out.");
        }
    }

    public void checkIn() {
        if (isCheckedOut) {
            isCheckedOut = false;
            dueDate = null;
        } else {
            System.out.println("Book is already checked in.");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", dueDate=" + (dueDate != null ? dueDate : "None") +
                '}';
    }
}
