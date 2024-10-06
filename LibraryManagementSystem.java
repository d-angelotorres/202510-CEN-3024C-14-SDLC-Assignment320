import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private List<Book> books;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
    }

    public void addBooksFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];
                books.add(new Book(id, title, author));
            }
            System.out.println("Books loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public void removeBookById(int id) {
        books.removeIf(book -> book.getId() == id);
        System.out.println("Book with ID " + id + " removed.");
    }

    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        System.out.println("Book with title '" + title + "' removed.");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the system.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.checkOut();
                System.out.println("Checked out: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void checkInBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.checkIn();
                System.out.println("Checked in: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
