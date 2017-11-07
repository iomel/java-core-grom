package Tasks.library;

import Tasks.library.DAO.AdminDAO;
import Tasks.library.DAO.BookDAO;
import Tasks.library.DAO.LibrarianDAO;
import Tasks.library.DAO.VisitorDAO;

public class Controller {

    private AdminDAO adminDAO = AdminDAO.getInstance();
    private LibrarianDAO librarianDAO = LibrarianDAO.getInstance();
    private VisitorDAO visitorDAO = VisitorDAO.getInstance();
    private BookDAO bookDAO = BookDAO.getInstance();

    public Controller() {
    }

}
