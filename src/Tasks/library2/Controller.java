package Tasks.library2;

import Tasks.library2.DAO.BookDAO;
import Tasks.library2.DAO.UserDAO;
import Tasks.library2.Utils.Role;
import Tasks.library2.Utils.Session;
import Tasks.library2.model.Book;
import Tasks.library2.model.User;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Controller {
    private static UserDAO userDAO = UserDAO.getInstance();
    private static BookDAO bookDAO = BookDAO.getInstance();

    // ADMIN's methods
    // ****************************************************
    public User addLibrarian(Session session, User newLibrarian){
        // Access check to invoke the method and whether new user is really librarian and not empty
        if(hasAccess(session) && (newLibrarian != null && newLibrarian.getRole() == Role.Librarian))
            return userDAO.add(newLibrarian);
        return null;
    }

    public void viewLibrarian(Session session){
        if(hasAccess(session)) // Access check to invoke the method
            for(User u : userDAO.getUsers(Role.Librarian))
                System.out.println(u.toString());
    }

    public void deleteLibrarian(Session session, User librarian){
        if(hasAccess(session) && (userDAO.hasUser(librarian) && librarian.getRole() == Role.Librarian)) // Access check to invoke the method
            userDAO.delete(librarian);
    }

    // END ADMIN's methods
    // ****************************************************

    // Librarians's methods
    // ****************************************************

    public void addBook(Session session, Book book, int quantity) {
        if(hasAccess(session))  // Access check to invoke the method
            bookDAO.add(book, quantity);
    }

    public void viewAllBooks(Session session){
        if(hasAccess(session)){   // Access check to invoke the method
            System.out.println("\n ***  Library books :");
            for(Book book : bookDAO.getBooks())
                System.out.println(book.toString());
        }
    }

    public void viewIssuedBooks(Session session){
        if(hasAccess(session)){   // Access check to invoke the method
            System.out.println("\n ***  Issued books :");
            for(Book book : bookDAO.getIssuedBooks())
                System.out.println(book.toString());
        }
    }

    // Librarians's AND Visitor's methods
    // ****************************************************

    public void issueBook(Session session, String callNo, User visitor) {
        if(hasAccess(session) && userDAO.hasUser(visitor) && !hasExpiredBook(visitor))    // Access check to invoke the method
            bookDAO.issueBook(callNo, visitor);
    }

    public void returnAllBooks(Session session, User visitor) {
        if(hasAccess(session) && userDAO.hasUser(visitor))    // Access check to invoke the method
            for (Book book : bookDAO.getBooks(visitor))
                bookDAO.returnBook(book);
    }

    public void returnBook(Session session, String callNo, User visitor) {
        if(hasAccess(session) && userDAO.hasUser(visitor)){   // Access check to invoke the method
            for (Book book : bookDAO.getBooks(visitor))
                if (book.getCallNo().equals(callNo))
                    bookDAO.returnBook(book);
        }
    }

    // Admin's AND Librarians's AND Visitor's method
    // ****************************************************

    public void logout (Session session){
        User user = userDAO.getUser(session.getSessionID());
        if (user != null)
            user.setSessionID(null);
        session.setExpired(true);
    }

    // Internal features methods *********

    // Access check
    private boolean hasAccess(Session session){
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        if(session != null && session.getAttributes().contains(methodName) && !session.isExpired())
            return true;

        if (session.isExpired())
            System.out.print("Session is expired! ");
        System.out.println("Not allowed to use this operation!");
        return false;
    }

    public Session login (User user) {
        return userDAO.hasUser(user) ? new Session(user) : null;
    }

    private Book getBookByCallNo(String callNo, User visitor){
        if (callNo != null && visitor != null) {
            for (Book b : bookDAO.getBooks(visitor))
                if (b.getCallNo().equals(callNo))
                    return b;
        }
        return null;
    }
    // Check weather USER has expired books TRUE - has, FALSE - hasn't
    private boolean hasExpiredBook(User visitor){
        if (visitor != null) {
            long dateDiff;
            for (Book book : bookDAO.getBooks(visitor)) {
                dateDiff = new Date().getTime() - book.getIssuedDate().getTime();
                if (TimeUnit.DAYS.convert(dateDiff, TimeUnit.MILLISECONDS) >= 30)   // 30 days term check
                    return true;
            }
        }
        return false;
    }


    // Methods FOR TEST data fill  *********************************
    void addTestUser(User user){
        userDAO.add(user);
    }

    void addTestBook(Book book, int quantity){
        bookDAO.add(book, quantity);
    }

}

