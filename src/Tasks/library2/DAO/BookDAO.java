package Tasks.library2.DAO;

import Tasks.library2.model.Book;
import Tasks.library2.model.User;

import java.util.HashSet;

public class BookDAO {
    private static BookDAO instance;
    private HashSet<Book> books = new HashSet<>();

    private BookDAO(){}

    public static BookDAO getInstance(){
        if(instance == null)
            instance = new BookDAO();
        return instance;
    }

    public void add(Book book, int quantity){
        if(book != null)
            for (int i = 0; i < quantity; i++)
                books.add(new Book(book.getCallNo(), book.getName()));
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public Book issueBook(String callNo, User visitor){
        Book book = isAvailable(callNo);
        if (book != null) {
            book.setIssued(true);
            book.setReader(visitor);
        }
        return book;
    }

    public void returnBook(Book book){
        if (book != null) {
            book.setIssued(false);
            book.dropReader();
        }
    }

    private boolean hasDuplicate(Book book){
        for (Book b : books)
            if(b.getCallNo().equals(book.getCallNo()))
                return true;
        return false;
    }

    private int getQuantity(String callNo){
        int quantity = 0;
        for (Book b : books)
            if(b.getCallNo().equals(callNo))
                quantity++;
        return quantity;
    }

    private Book isAvailable(String callNo){
        for (Book b : books)
            if(b.getCallNo().equals(callNo) && !b.isIssued())
                return b;
        return null;
    }

}
