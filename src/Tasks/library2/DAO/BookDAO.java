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

    public HashSet<Book> getBooks(User user){
        HashSet<Book> readerBooks = new HashSet<>();
        for(Book book : books)
            if (book.getReader()!= null && book.getReader().getId() == user.getId())
                readerBooks.add(book);
        return readerBooks;
    }
    public HashSet<Book> getIssuedBooks() {
        HashSet<Book> issuedBooks = new HashSet<>();
        for(Book book : books)
            if(book.isIssued())
                issuedBooks.add(book);
        return issuedBooks;
    }

    public Book issueBook(String callNo, User visitor){
        Book book = isAvailable(callNo);
        if (book != null) {
            book.setIssued(true);
            book.setReader(visitor);
            return book;
        }
        System.out.println("Book is not available - could not be issued!");
        return null;
    }

    public void returnBook(Book book){
        if (book != null) {
            book.setIssued(false);
            book.dropReader();
        }
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
