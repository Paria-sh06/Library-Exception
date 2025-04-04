import com.sun.jdi.ArrayReference;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Book> borrowedBooks;

    public Library() {
        this.books = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
    }

    public void addBook(Book book) throws InvalidBookException {
        if (book == null) {
            throw new InvalidBookException("Book should not be null.");
        }
        books.add(book);
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    private Book findBrrowedBook(String title) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty, no books to borrow.");
        }

        Book book = findBook(title);
        if (book == null) {
            throw new BookNotFoundException("Book with title \"" + title + "\" not found.");
        }

        System.out.println();
        System.out.println("Successfully borrowed book: " + book);
        System.out.println();
        books.remove(book);
        borrowedBooks.add(book);
    }

    public void returnBook(String title) throws BookNotFoundException {
        Book book = findBrrowedBook(title);
        if (book == null) {
            throw new BookNotFoundException("Cannot return. Book with title \"" + title + "\" not found.");
        }

        books.add(book);
        borrowedBooks.remove(book);
    }

    public void listBooks() throws EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty.");
        }
        for (Book book : books) {
            System.out.println("- " + book);
        }
    }
}
