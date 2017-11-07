package Tasks.library;

import Tasks.library.DAO.AdminDAO;
import Tasks.library.DAO.BookDAO;
import Tasks.library.DAO.LibrarianDAO;
import Tasks.library.DAO.VisitorDAO;
import Tasks.library.model.Admin;
import Tasks.library.model.Book;
import Tasks.library.model.Visitor;

public class Controller {

    private AdminDAO adminDAO = AdminDAO.getInstance();
    private LibrarianDAO librarianDAO = LibrarianDAO.getInstance();
    private VisitorDAO visitorDAO = VisitorDAO.getInstance();
    private BookDAO bookDAO = BookDAO.getInstance();

    public Controller() {
    }
    // Admin activity methods ADD / DELETE / VIEW
    public Admin addAdmin(Admin admin){
        if (admin != null)
            adminDAO.add(admin);
        return admin;
    }

    public void deleteAdmin(long id){
            adminDAO.delete(id);
    }

    public void viewAdmins(){
        adminDAO.view();
    }

    // Librarian activity methods ADD / DELETE / VIEW
        // TODO

    public LibrarianDAO getLibrarianDAO() {
        return librarianDAO;
    }

    // Visitor activity methods ADD / DELETE / VIEW
    public Visitor addVisitor(Visitor visitor){
        if (visitor != null)
            visitorDAO.add(visitor);
        return visitor;
    }

    public void deleteVisitor(long id){
        visitorDAO.delete(id);
    }

    public void viewVisitors(){
        visitorDAO.view();
    }

    // Book activity methods ADD / DELETE / VIEW
    public Book addBook(Book book){
        if (book != null)
            bookDAO.add(book);
        return book;
    }

    public void deleteBook(long id){
        bookDAO.delete(id);
    }

    public void viewBooks(){
        bookDAO.view();
    }

}
