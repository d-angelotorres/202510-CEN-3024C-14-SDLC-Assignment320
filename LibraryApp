import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Ask user for file name
        System.out.println("Enter the file name to load books:");
        String fileName = scanner.nextLine();
        lms.addBooksFromFile(fileName);
        lms.listBooks();

        // Remove book by ID
        System.out.println("\nEnter a book ID to remove:");
        int id = scanner.nextInt();
        lms.removeBookById(id);
        lms.listBooks();

        // Remove book by Title
        scanner.nextLine();  // Consume newline
        System.out.println("\nEnter a book title to remove:");
        String titleToRemove = scanner.nextLine();
        lms.removeBookByTitle(titleToRemove);
        lms.listBooks();

        // Check out a book by Title
        System.out.println("\nEnter a book title to check out:");
        String titleToCheckOut = scanner.nextLine();
        lms.checkOutBook(titleToCheckOut);
        lms.listBooks();

        // Check in a book by Title
        System.out.println("\nEnter a book title to check in:");
        String titleToCheckIn = scanner.nextLine();
        lms.checkInBook(titleToCheckIn);
        lms.listBooks();

        scanner.close();
    }
}
