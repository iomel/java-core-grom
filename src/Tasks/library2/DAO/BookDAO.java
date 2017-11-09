package Tasks.library2.DAO;

import Tasks.library2.model.Book;
import Tasks.library2.model.User;

import java.util.Date;
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

    public Book add(Book book){
        if(book != null && !hasDuplicate(book))
            books.add(book);
        return book;
    }

    public void delete(Book book){
        if(book != null)
            books.remove(book);
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public Book issueBook(Book book, User visitor){
        if (book != null && book.getQuantity()>0) {
            book.setQuantity(book.getQuantity()-1);
            book.setIssued(book.getIssued()+1);
            book.setReader(visitor.getId());
            visitor.addBook(book.getCallNo(), new Date());
        }
        return book;
    }

    public Book returnBook(Book book, User visitor){
        if (book != null) {
            book.setQuantity(book.getQuantity()+1);
            book.setIssued(book.getIssued()-1);
            book.removeReader(visitor.getId());
            visitor.removeBook(book.getCallNo());
        }
        return book;
    }

    private boolean hasDuplicate(Book book){
        for (Book b : books)
            if(b.getCallNo().equals(book.getCallNo()))
                return true;
        return false;
    }

}
