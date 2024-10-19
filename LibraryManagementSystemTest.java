import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryManagementSystemTest {

    private LibraryManagementSystem lms;

    @Before
    public void setUp() {
        lms = new LibraryManagementSystem();
        // Add books manually for testing
        lms.addBooksFromFile("Books.txt"); // Assuming the file exists and contains books
    }

    @Test
    public void testAddBooksFromFile() {
        // Check that books are added
        List<Book> books = lms.getBooks();
        assertEquals(3, books.size());

        // Verify the first book's details
        assertEquals("To Kill a Mockingbird", books.get(0).getTitle());
        assertEquals("Harper Lee", books.get(0).getAuthor());
    }

    @Test
    public void testRemoveBookById() {
        // Remove a book by ID
        lms.removeBookById(1);
        List<Book> books = lms.getBooks();

        // Verify the size after removal and check that the book with ID 1 is gone
        assertEquals(2, books.size());
        assertNull(findBookById(books, 1));
    }

    @Test
    public void testRemoveBookByTitle() {
        // Remove a book by Title
        lms.removeBookByTitle("1984");
        List<Book> books = lms.getBooks();

        // Verify the size after removal and check that the book with the title "1984" is gone
        assertEquals(2, books.size());
        assertNull(findBookByTitle(books, "1984"));
    }

    @Test
    public void testCheckOutBook() {
        // Check out a book
        lms.checkOutBook("The Great Gatsby");
        Book book = findBookByTitle(lms.getBooks(), "The Great Gatsby");

        // Verify that the book is checked out and has a due date
        assertTrue(book.isCheckedOut());
        assertNotNull(book.getDueDate());
    }

    @Test
    public void testCheckInBook() {
        // First, check out a book to ensure it has a due date
        lms.checkOutBook("The Great Gatsby");
        Book book = findBookByTitle(lms.getBooks(), "The Great Gatsby");

        // Then, check in the book
        lms.checkInBook("The Great Gatsby");

        // Verify that the book is checked in and no longer has a due date
        assertFalse(book.isCheckedOut());
        assertNull(book.getDueDate());
    }

    // Helper methods to find books by ID or Title
    private Book findBookById(List<Book> books, int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    private Book findBookByTitle(List<Book> books, String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }
}
