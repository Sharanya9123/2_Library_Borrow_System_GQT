package core_java_projects;

import java.util.ArrayList;
import java.util.Scanner;

// Class to hold book details
class Book {
    private int bookId;
    private String title;
    private boolean isBorrowed;

    // Setter methods
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void borrowBook() {
        this.isBorrowed = true;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public int getBookId() {
        return bookId;
    }

    // Display book info
    public void display() {
        String status = isBorrowed ? "Borrowed" : "Available";
        System.out.println("Book ID: " + bookId + " | Title: " + title + " | Status: " + status);
    }
}

// Main class
public class Library_Borrow_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();
        int choice;

        // Thematic greeting
        System.out.println(" Welcome to the Library Book Borrowing System ");
        System.out.println("--------------------------------------------------");
        System.out.println("A place where stories live and learning never ends!");
        System.out.println("--------------------------------------------------");

        // Menu loop
        do {
            System.out.println("\n📖 Enter the option you want:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. View All Books");
            System.out.println("4. Exit");
            System.out.print("Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Add a book
                    Book b = new Book();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Book ID: ");
                    b.setBookId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    b.setTitle(sc.nextLine());

                    library.add(b);
                    System.out.println(" Book added to the library!");
                    break;

                case 2:
                    // Borrow a book
                    if (library.isEmpty()) {
                        System.out.println(" No books available to borrow.");
                    } else {
                        System.out.print("Enter Book ID to borrow: ");
                        int idToBorrow = sc.nextInt();
                        boolean found = false;

                        for (Book book : library) {
                            if (book.getBookId() == idToBorrow) {
                                found = true;
                                if (book.isBorrowed()) {
                                    System.out.println(" Book already borrowed.");
                                } else {
                                    book.borrowBook();
                                    System.out.println(" Book borrowed successfully!");
                                }
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println(" Book ID not found.");
                        }
                    }
                    break;

                case 3:
                    // View books
                    if (library.isEmpty()) {
                        System.out.println(" Library is empty.");
                    } else {
                        System.out.println(" List of Books:");
                        for (Book book : library) {
                            book.display();
                        }
                    }
                    break;

                case 4:
                    // Farewell message
                    System.out.println("\nThanks for visiting the Library! ");
                    System.out.println("Come back soon for your next read. ");
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }

        } while (choice != 4);
    }
}
