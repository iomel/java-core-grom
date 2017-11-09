package Tasks.library2;

import Tasks.library2.DAO.BookDAO;
import Tasks.library2.DAO.UserDAO;
import Tasks.library2.Utils.Role;
import Tasks.library2.model.Book;
import Tasks.library2.model.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Controller {
    private static UserDAO userDAO = UserDAO.getInstance();
    private static BookDAO bookDAO = BookDAO.getInstance();
    private int access; // | 0 - Admin | 1 - Librarian | 666 - Access denied | other - Visitor


    public void login (User user) {
        for (User u : userDAO.getUsers())
            if(u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword())){
                access = user.getRole().ordinal();
                return;
            }
        access = 666;
    }

    // ADMIN's methods
    // ****************************************************
    public User addLibrarian(User newLibrarian){
        if(access == 0 && (newLibrarian != null && newLibrarian.getRole() == Role.Librarian))
            return userDAO.add(newLibrarian);
        return null;
    }

    public void viewLibrarian(){
        if(access == 0){
            for(User u : userDAO.getUsers())
                if(u.getRole() == Role.Librarian)
                    System.out.println(u.toString());
        }
    }

    public void deleteLibratian(User librarian){
        if((access == 0) && (librarian != null && librarian.getRole() == Role.Librarian))
            userDAO.delete(librarian);
    }
    // END ADMIN's methods
    // ****************************************************

    // Librarians's methods
    // ****************************************************

    public Book addBook(Book book) {
        if(access == 1 && book != null)
            return bookDAO.add(book);
        return null;
    }

    public void viewAllBooks(){
        if(access == 1){
            System.out.println("\n ***  Library books :");
            for(Book book : bookDAO.getBooks())
                System.out.println(book.toString());
        }
    }

    public void viewIssuedBooks(){
        if(access == 1){
            System.out.println("\n ***  Issued books :");
            for(Book book : bookDAO.getBooks())
                if(book.getIssued() > 0)
                    System.out.println(book.toString());
        }
    }

    // Librarians's AND Visitor's methods
    // ****************************************************

    public void issueBook(Book book, User visitor) {
        if((access == 1 || access == 2) && visitor != null){
            if(hasExpiredBook(visitor)){
                System.out.println(visitor.getName() + " has expired books! Book couldn't be issued!");
                return;
            }

            if (bookDAO.issueBook(book, visitor) == null)
                System.out.println("Wrong information. Book was not issued!");
        }
    }

    public void returnAllBooks(User visitor) {
        if((access == 1 || access == 2) && visitor != null)
            for (Map.Entry<String, Date> visitorsBook : visitor.getBooks().entrySet())
                if (bookDAO.returnBook(getBookByCallNo(visitorsBook.getKey()), visitor) == null)
                    System.out.println("Wrong information. Book couldn't be returned!");
    }

    public void returnBook(Book book, User visitor) {
        if((access == 1 || access == 2) && visitor != null) {
           if (bookDAO.returnBook(book, visitor) == null)
                System.out.println("Wrong information. Book couldn't be returned!");
        }
    }

    // Admin's AND Librarians's AND Visitor's method
    // ****************************************************

    public void logout (){
        access = 666;
    }

    // Internal features methods *********
    // Check weather USER has expired books TRUE - has, FALSE - hasn't
    private boolean hasExpiredBook(User user){
        HashMap<String, Date> books = user.getBooks();
        Date today = new Date();
        long diff;
        for(Map.Entry<String, Date> book : books.entrySet()){
            diff = today.getTime() - book.getValue().getTime();
            if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) >= 30)
                return true;
        }
        return false;
    }

    private Book getBookByCallNo (String callNo){
        for(Book book : bookDAO.getBooks())
            if(book.getCallNo().equals(callNo))
                return book;
        return null;
    }

    // Methods FOR TEST data fill  *********************************
    void addTestUser(User user){
        userDAO.add(user);
    }

    void addTestBook(Book book){
        bookDAO.add(book);
    }

}

