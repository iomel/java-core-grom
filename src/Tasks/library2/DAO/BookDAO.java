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
        if(book != null)
            books.add(book);
        return book;
    }

    public void delete(Book book){
        if(book != null)
            books.remove(book);
    }

    public void viewAll(){
        for(Book book : books)
            System.out.println(book.toString());
    }

    public void viewIssued(){
        for(Book book : books)
            if(book.getIssued() > 0)
                System.out.println(book.toString());
    }


    public Book issueBook(String callNo, User visitor){
        Book book = getBook(callNo);
        if (book != null && book.getQuantity()>0) {
            book.setQuantity(book.getQuantity()-1);
            book.setIssued(book.getIssued()+1);
            book.setReader(visitor.getId());
            visitor.addBook(callNo, new Date());
        }
        return book;
    }

    private Book getBook(String callNo){
        for(Book book : books)
            if (book.getCallNo().equals(callNo))
                return book;
        return null;
    }
}
