public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        try {
            System.out.println("\tList of the books in the library: ");
            library.listBooks();
        } catch (EmptyLibraryException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println();
        }

        Book book1 = null;
        Book book2 = null;
        Book book3 = null;
        Book book4 = null;

        try {
            book1 = new Book("Java Programming", 300);
            System.out.println("Book successfully created: " + book1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            book2 = new Book("Design Patterns", -3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            book3 = new Book(null, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            book4 = new Book("", 400);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println();
        }

//        try {
//            if (book1 != null) {
//                library.addBook(book1);
//                System.out.println("Book successfully added: " + book1);
//            }
//            if (book2 != null) library.addBook(book2);
//            if (book3 != null) library.addBook(book3);
//           if (book4 != null) library.addBook(book4);
//        } catch (InvalidBookException e) {
//            System.out.println("Error: " + e.getMessage());
//        }

        try{
            library.addBook(book1);
            System.out.println("Book successfully added : " + book1);
        }catch(InvalidBookException e){
            System.out.println("Error: " + e.getMessage());
        }

        try{
            library.addBook(book2);
        }catch(InvalidBookException e){
            System.out.println("Error: " + e.getMessage());
        }

        try{
            library.addBook(book3);
        }catch(InvalidBookException e){
            System.out.println("Error: " + e.getMessage());
        }

        try{
            library.addBook(book4);
        }catch(InvalidBookException e){
            System.out.println("Error: " + e.getMessage());
            System.out.println();
        }

        try {
            System.out.println("\tList of the books in the library :");
            library.listBooks();
        } catch (EmptyLibraryException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            library.borrowBook("Java Programming");
        } catch (EmptyLibraryException | BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            library.returnBook("Java Programming");
            System.out.println("Successfully returned to the library: " + book1);
            System.out.println();
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try{
            library.returnBook("Clean Code");
        } catch (BookNotFoundException e) {
        System.out.println("Error: " + e.getMessage());
    }
    }
}
