import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/library_management";
    private static final String USER = "root";
    private static final String PASSWORD = "Compaq123";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    // Insert method for adding a book
    public void insertBook(String title, String author, int year) {
        String insertSQL = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";  // No 'id' column, since it's auto-generated

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set the values for the query placeholders
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setInt(3, year);

            // Execute the insert statement
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book inserted successfully!");
            } else {
                System.out.println("No book inserted.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting book: " + e.getMessage());
        }
    }
}