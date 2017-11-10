package Tasks.library2;

import Tasks.library2.DAO.BookDAO;
import Tasks.library2.DAO.UserDAO;
import Tasks.library2.Utils.Role;
import Tasks.library2.model.Book;
import Tasks.library2.model.User;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Controller {
    private static UserDAO userDAO = UserDAO.getInstance();
    private static BookDAO bookDAO = BookDAO.getInstance();


    // ADMIN's methods
    // ****************************************************
    public User addLibrarian(User user, User newLibrarian){
        if(hasAccess(user, Role.Admin) && (newLibrarian != null && newLibrarian.getRole() == Role.Librarian))  // Access check to invoke the method
            return userDAO.add(newLibrarian);
        return null;
    }

    public void viewLibrarian(User user){
        if(hasAccess(user, Role.Admin)) // Access check to invoke the method
            for(User u : userDAO.getUsers(Role.Librarian))
                System.out.println(u.toString());
    }

    public void deleteLibrarian(User user, User librarian){
        if(hasAccess(user, Role.Admin) && (librarian != null && librarian.getRole() == Role.Librarian)) // Access check to invoke the method
            userDAO.delete(librarian);
    }

    // END ADMIN's methods
    // ****************************************************

    // Librarians's methods
    // ****************************************************

    public void addBook(User user, Book book, int quantity) {
        if(hasAccess(user, Role.Librarian) && book != null)  // Access check to invoke the method
            bookDAO.add(book, quantity);
    }

    public void viewAllBooks(User user){
        if(hasAccess(user, Role.Librarian)){   // Access check to invoke the method
            System.out.println("\n ***  Library books :");
            for(Book book : bookDAO.getBooks())
                System.out.println(book.toString());
        }
    }

    public void viewIssuedBooks(User user){
        if(hasAccess(user, Role.Librarian)){   // Access check to invoke the method
            System.out.println("\n ***  Issued books :");
            for(Book book : bookDAO.getBooks())
                if(book.isIssued())
                    System.out.println(book.toString());
        }
    }

    // Librarians's AND Visitor's methods
    // ****************************************************

    public void issueBook(User user, String callNo, User visitor) {
        if(!(hasAccess(user, Role.Librarian, Role.Visitor)) || !userDAO.hasUser(visitor) || hasExpiredBook(visitor))   // Access check to invoke the method
            return;

        Book book = bookDAO.issueBook(callNo, visitor);
        if (book != null)
            visitor.addBook(book);
        else
            System.out.println("Book is not available - could not be issued!");
    }

    public void returnAllBooks(User user, User visitor) {
        if(hasAccess(user, Role.Librarian, Role.Visitor) && userDAO.hasUser(visitor)) {   // Access check to invoke the method
            for (Book book : visitor.getBooks()) {
                bookDAO.returnBook(book);
                visitor.removeBook(book);
            }
        }
    }

    public void returnBook(User user, String callNo, User visitor) {
        if(hasAccess(user, Role.Librarian, Role.Visitor) && userDAO.hasUser(visitor)){   // Access check to invoke the method
            Book bookToReturn = getBookByCallNo(callNo, visitor);

            if(bookToReturn != null) {
                bookDAO.returnBook(bookToReturn);
                visitor.removeBook(bookToReturn);
            }
        }
    }

    // Admin's AND Librarians's AND Visitor's method
    // ****************************************************

    public void logout (User user){
        if (userDAO.hasUser(user))
            user.setActive(false);
    }

    // Internal features methods *********

    // Access check
    private boolean hasAccess(User user, Role... roles){
        HashSet<Role> allowedRoles = new HashSet<>(Arrays.asList(roles));
        if (user != null && isLoggedIn(user) && allowedRoles.contains(user.getRole()))
            return true;
        System.out.println("User is not allowed to use this feature!");
        return false;
    }

    private boolean isLoggedIn(User user){
        if(user == null){
            System.out.println("Error - USER is empty!");
            return false;
        } else if (!userDAO.hasUser(user)) {
            System.out.println("User is not a library stuff or member!");
            return false;
        } else if (!user.isActive()) {
            System.out.println("Error - USER is not logged in the system!");
            return false;
        }
        return true;
    }

    public boolean login (User user) {
        if (userDAO.hasUser(user)) {
            user.setActive(true);
            return true;
        }
        return false;
    }

    private Book getBookByCallNo(String callNo, User visitor){
        Book book = null;
        if (callNo != null && visitor != null)
            for (Book b : visitor.getBooks())
                if(b.getCallNo().equals(callNo))
                    book = b;
        return book;
    }
    // Check weather USER has expired books TRUE - has, FALSE - hasn't
    private boolean hasExpiredBook(User user){
        if (user != null && user.getBooks() != null) {
            HashSet<Book> books = user.getBooks();
            Date today = new Date();
            long diff;
            for (Book book : books) {
                diff = today.getTime() - book.getIssuedDate().getTime();
                if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) >= 30)   // 30 days term check
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

