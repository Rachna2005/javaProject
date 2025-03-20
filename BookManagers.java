import java.util.ArrayList;

public class BookManagers{
    private static ArrayList<Book> books = new ArrayList<>();

    // Initialize with some dummy books
    static {
        books.add(new Book("Math", "F. Scott Fitzgerald=", "A classic novel about the American dream."));
        books.add(new Book("1984", "George Orwell", "A dystopian novel about a totalitarian regime."));
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static void addBook(Book book) {
        books.add(book);
    }

    public static boolean deleteBook(String title) {
        return books.removeIf(book -> book.getTitle().equals(title));
    }
}
