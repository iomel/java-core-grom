package Tasks.library2;

import Tasks.library2.DAO.BookDAO;
import Tasks.library2.DAO.UserDAO;
import Tasks.library2.Utils.Role;
import Tasks.library2.Utils.Session;
import Tasks.library2.Utils.SessionStorage;
import Tasks.library2.model.Book;
import Tasks.library2.model.User;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Controller {
    private static UserDAO userDAO = UserDAO.getInstance();
    private static BookDAO bookDAO = BookDAO.getInstance();
    private static SessionStorage sessions = SessionStorage.getInstance();

    // ADMIN's methods
    // ****************************************************
    public User addLibrarian(User user, User newLibrarian){
        // Access check to invoke the method and whether new user is really librarian and not empty
        if(hasAccess(user) && (newLibrarian != null && newLibrarian.getRole() == Role.Librarian))
            return userDAO.add(newLibrarian);
        return null;
    }

    public void viewLibrarian(User user){
        if(hasAccess(user)) // Access check to invoke the method
            for(User u : userDAO.getUsers(Role.Librarian))
                System.out.println(u.toString());
    }

    public void deleteLibrarian(User user, User librarian){
        if(hasAccess(user) && (userDAO.hasUser(librarian) && librarian.getRole() == Role.Librarian)) // Access check to invoke the method
            userDAO.delete(librarian);
    }

    // END ADMIN's methods
    // ****************************************************

    // Librarians's methods
    // ****************************************************

    public void addBook(User user, Book book, int quantity) {
        if(hasAccess(user))  // Access check to invoke the method
            bookDAO.add(book, quantity);
    }

    public void viewAllBooks(User user){
        if(hasAccess(user)){   // Access check to invoke the method
            System.out.println("\n ***  Library books :");
            for(Book book : bookDAO.getBooks())
                System.out.println(book.toString());
        }
    }

    public void viewIssuedBooks(User user){
        if(hasAccess(user)){   // Access check to invoke the method
            System.out.println("\n ***  Issued books :");
            for(Book book : bookDAO.getIssuedBooks())
                System.out.println(book.toString());
        }
    }

    // Librarians's AND Visitor's methods
    // ****************************************************

    public void issueBook(User user, String callNo, User visitor) {
        if(hasAccess(user) && userDAO.hasUser(visitor) && !hasExpiredBook(visitor))    // Access check to invoke the method
            visitor.addBook(bookDAO.issueBook(callNo, visitor));
    }

    public void returnAllBooks(User user, User visitor) {
        if(hasAccess(user) && userDAO.hasUser(visitor)) {   // Access check to invoke the method
            for (Book book : visitor.getBooks()) {
                bookDAO.returnBook(book);
                visitor.removeBook(book);
            }
        }
    }

    public void returnBook(User user, String callNo, User visitor) {
        if(hasAccess(user) && userDAO.hasUser(visitor)){   // Access check to invoke the method
            Book bookToReturn = getBookByCallNo(callNo, visitor);
            bookDAO.returnBook(bookToReturn);
            visitor.removeBook(bookToReturn);
        }
    }

    // Admin's AND Librarians's AND Visitor's method
    // ****************************************************

    public void logout (User user){
        if (userDAO.hasUser(user))
            user.setSessionID(sessions.remove(user.getSessionID()));
        hasAccess(user);
    }

    // Internal features methods *********

    // Access check
    private boolean hasAccess(User user){
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Session checkedSession = sessions.getSession(user.getSessionID());
        if(checkedSession != null && checkedSession.getAttributes().contains(methodName))
            return true;
        System.out.println("User has no right to use this operation!");
        return false;
    }

    public void login (User user) {
        if (userDAO.hasUser(user))
            user.setSessionID(sessions.create(user));
    }

    private Book getBookByCallNo(String callNo, User visitor){
        for (Book b : visitor.getBooks())
            if(b.getCallNo().equals(callNo))
                return b;
        return null;
    }
    // Check weather USER has expired books TRUE - has, FALSE - hasn't
    private boolean hasExpiredBook(User user){
        if (user != null && user.getBooks() != null) {
            long dateDiff;
            for (Book book : user.getBooks()) {
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

