public class Main {
    public static void main(String[] args) {
        DatabaseHelper dbHelper = new DatabaseHelper();

        // Example data
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";
        int year = 1925;

        // Insert book into the database
        dbHelper.insertBook(title, author, year);
    }
}
