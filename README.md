# 202510-CEN-3024C-14-SDLC-Assignment320

1. Introduction
This document outlines the software requirements for the development of a Library Management System (LMS), detailing the functional and non-functional requirements, constraints, and the implementation and testing plans.

The Library Management System (LMS) is a console-based application used to manage a library's book collection. Users will be able to list, edit, and delete books from the library's collection using the system. The LMS attempts to provide effective information access and make managing book collections for librarians easier.

2. System Users
•	Primary Users:
o	Librarians: In charge of overseeing the library's book collection, librarians are the primary system users.
•	Secondary Users:
o	Library Assistants: People who could help keep the book collection current and in good condition by helping librarians.

3. Functional Requirements
The LMS needs to meet the following functional specifications:

1. Add New Books to the Collection:
•	Description: By reading information from a text file, the system ought to enable users to add new books to the library's collection.
•	Input: Book records in a text file (books.txt), separated by a new line between each entry. Every record has the following information: A distinct ID number; The book's title; The author of the book
•	Output: The new books from the file are added to the collection by the system.

2. Remove a Book from the Collection:
•	Description: By entering a book's unique ID number, users should be able to delete it from the collection using the system.
•	Input: The book's ID number that must be deleted.
•	Output: The designated book is eliminated from the assortment.

3. List All Books in the Collection:
•	Description: Users should be able to view every book that is currently part of the library's collection via the system.
•	Input: Since an instruction initiates the action, no input is necessary.
•	Output: A list of every book in the collection that looks like this: The book's author; the book's title; and the ID number
 
4. Non-Functional Requirements
•	Usability:
o	The system ought to be easy to use, with straightforward commands and clear outputs.
•	Performance:
o	The system should be capable of efficiently handling and processing huge text files with many book records.
•	Reliability:
o	The text file's input data should be accurately processed by the system to guarantee that all books are included, and that any erroneous data is dealt with properly.
•	Maintainability:
o	Modularity should be considered in the system's architecture to facilitate future code updates and maintenance.
•	Security:
o	Data integrity should be preserved by the system, especially while books are being removed from the collection. Checks should be in place to stop books from being unintentionally removed.

5. Constraints
•	Platform: As a console-based program, the system ought to function on any platform that has Java support.
•	Data Format: The books.txt file must adhere to a particular format; fields should be separated by commas and each book's data should be on a single line.
•	Error Handling: The system should gracefully manage mistakes including missing files, improper file formats, and invalid input data while informing the user of the faults in a clear and understandable manner.

6. Assumptions
•	The proper format of the text file books.txt will be supplied.
•	Users will be familiar with the fundamentals of using a console-based program.
•	Concurrency management and multi-user support are not needed for the system because the library's book collection is overseen by a small crew.
 
7. Gathering Requirements
To gather requirements for the Library Management System (LMS), the following approaches were used:

•	Interviews with Librarians and Library Assistants: To better understand the needs of primary and secondary users, we conducted fictitious interviews with them. The need for a simple system that prioritizes effectiveness and usability in managing the book collection was voiced by librarians. They underlined how crucial it was to have a system that could manage massive data sets and guarantee precise record-keeping.
•	Observation of Current Practices: Time wasted, and frequent mistakes made in book management chores were noted during an examination of the current manual operations. The findings demonstrated the necessity of automated procedures to lower human error and improve operational efficiency.
•	Assumptions: Because the system is console-based, it was considered that users possess a basic understanding of command-line functionality. The users also mentioned how important it is to them for their everyday duties to be able to add, remove, and list books.

8. Implementation Plan
The implementation of the LMS will be broken down into the following phases:
•	Phase 1: Set Up Data Structures
o	Classes: 
	Book: Has properties like author, title, and id.
	LibraryManagementSystem: Oversees the book collection and related activities.
o	Methods:
	A new book is added to the collection using the addBook(String id, String title, String author) function.
	removeBook(String id): Use the ID of the book to remove it from the collection.
	listBooks(): Shows every book in the library.
o	Order of Implementation:
	1. To specify the structure of a book object, begin by creating the Book class.
	2. To manage the collection, create the LibraryManagementSystem class.
	3. Put the listBooks, addBook, and removeBook methods into action.
 
•	Phase 2: Implement File Handling
o	Method:
	importBooksFromFile(String filename) is the method used to add books to the collection by reading book data from a text file.
o	Order of Implementation:
   		1. To parse the text file, implement file reading capabilities
2. To fill the collection, combine the addBook and importBooksFromFile methods.
•	Phase 3: Validation and Error Handling
o	Enhancements:
	When adding a new book, include tests to make sure the book ID is distinct.
	Include error warnings for invalid actions, such trying to delete a book that doesn't exist.

9. Testing Plan
To ensure the system functions correctly, the following test cases will be executed:
•	Test Case 1: Include New Books
o	Input: An appropriately prepared text file containing book records.
o	Anticipated Output: No mistakes are detected, and books are added to the collection.
•	Test Case 2: Take a Book Out
o	Input: A valid book ID.
o	Expected Output: The book is eliminated from the compilation. The deleted book shouldn't be seen when trying to list the books.
•	Test Case 3: Enumerate Every Book
o	Input: Start the list command without receiving any further commands.
o	Expected Output: The list of all books that are presently part of the collection is shown, along with the ID, title, and author of each book.
•	Test Case 4: Error Handling for the Removal of Nonexistent Books
o	Input: An invalid book ID from the collection.
o	 Expected Output: The collection remains unchanged, and an error notice is shown.
•	Test Case 5: Importing Files
o	Input: A text file with several book records that is correctly formatted.
o	Expected Output: The file's books are all successfully added to the collection.
•	Test Case 6: Managing File Format Errors
o	Input: A poorly formed text file containing data (missing commas, for example).
o	Expected Output: The system does not crash, and an error notice appears. The remaining portions of the file are processed after invalid items are ignored.
