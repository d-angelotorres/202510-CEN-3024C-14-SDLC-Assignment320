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
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    public void removeBookById(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();

        // Provide the path to your books.txt file
        String filePath = "books.txt";

        lms.addBooksFromFile(filePath);
        lms.listBooks();
        lms.removeBookById(2);
        lms.listBooks();
    }
}
