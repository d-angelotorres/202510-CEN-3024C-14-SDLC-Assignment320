import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryManagementGUI extends JFrame {
    private LibraryManagementSystem lms;
    private JTextField fileNameField, idField, titleField;
    private JTextArea bookDisplayArea;
    private JLabel messageLabel;

    public LibraryManagementGUI() {
        lms = new LibraryManagementSystem();
        setTitle("Library Management System");

        // Initialize components
        fileNameField = new JTextField(20);
        idField = new JTextField(10);
        titleField = new JTextField(20);
        bookDisplayArea = new JTextArea(15, 50);
        bookDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(bookDisplayArea);
        messageLabel = new JLabel(" ");
        messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Padding for the message label

        // Load Books Button
        JButton loadBooksButton = new JButton("Load Books");
        loadBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadBooks();
            }
        });

        // Remove Book by ID Button
        JButton removeByIdButton = new JButton("Remove by ID");
        removeByIdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeBookById();
            }
        });

        // Remove Book by Title Button
        JButton removeByTitleButton = new JButton("Remove by Title");
        removeByTitleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeBookByTitle();
            }
        });

        // Check Out Book Button
        JButton checkOutButton = new JButton("Check Out Book");
        checkOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkOutBook();
            }
        });

        // Check In Book Button
        JButton checkInButton = new JButton("Check In Book");
        checkInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkInBook();
            }
        });

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Layout setup
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 1));

        JPanel loadPanel = new JPanel();
        loadPanel.add(new JLabel("File Name:"));
        loadPanel.add(fileNameField);
        loadPanel.add(loadBooksButton);

        JPanel removePanel = new JPanel();
        removePanel.add(new JLabel("ID:"));
        removePanel.add(idField);
        removePanel.add(removeByIdButton);

        // Move "Remove by Title" button next to title field
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Title:"));
        titlePanel.add(titleField);
        titlePanel.add(removeByTitleButton);
        titlePanel.add(checkOutButton);
        titlePanel.add(checkInButton);

        topPanel.add(loadPanel);
        topPanel.add(removePanel);
        topPanel.add(titlePanel);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Status label at the bottom for messages
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.add(messageLabel, BorderLayout.WEST);
        add(statusPanel, BorderLayout.SOUTH);

        add(exitButton, BorderLayout.PAGE_END);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Method to load books from file
    private void loadBooks() {
        String fileName = fileNameField.getText();
        lms.addBooksFromFile(fileName);
        updateBookDisplay();
        setMessage("Books loaded successfully!");
    }

    // Method to remove a book by ID
    private void removeBookById() {
        try {
            int id = Integer.parseInt(idField.getText());
            lms.removeBookById(id);
            updateBookDisplay();
            setMessage("Book with ID " + id + " removed.");
        } catch (NumberFormatException e) {
            setMessage("Invalid ID format.");
        }
    }

    // Method to remove a book by Title
    private void removeBookByTitle() {
        String title = titleField.getText();
        lms.removeBookByTitle(title);
        updateBookDisplay();
        setMessage("Book with title '" + title + "' removed.");
    }

    // Method to check out a book
    private void checkOutBook() {
        String title = titleField.getText();
        lms.checkOutBook(title);
        updateBookDisplay();
        setMessage("Book '" + title + "' checked out.");
    }

    // Method to check in a book
    private void checkInBook() {
        String title = titleField.getText();
        lms.checkInBook(title);
        updateBookDisplay();
        setMessage("Book '" + title + "' checked in.");
    }

    // Method to update the display area with the list of books
    private void updateBookDisplay() {
        StringBuilder displayText = new StringBuilder();
        for (Book book : lms.getBooks()) {
            displayText.append(book).append("\n");
        }
        bookDisplayArea.setText(displayText.toString());
    }

    // Method to update the status message label
    private void setMessage(String message) {
        messageLabel.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagementGUI());
    }
}

