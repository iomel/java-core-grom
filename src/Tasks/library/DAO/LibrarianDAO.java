package Tasks.library.DAO;

import Tasks.library.Librarian;

public class LibrarianDAO extends GeneralDAO<Librarian>{

    private static LibrarianDAO instance;

    private LibrarianDAO() {
    }

    public static LibrarianDAO getInstance() {
        if (instance == null)
            instance = new LibrarianDAO();
        return instance;
    }
}
