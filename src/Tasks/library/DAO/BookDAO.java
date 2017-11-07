package Tasks.library.DAO;

import Tasks.library.Book;

public class BookDAO extends GeneralDAO<Book> {

    private static BookDAO instance;

    private BookDAO() {
    }

    public static BookDAO getInstance() {
        if (instance == null)
            instance = new BookDAO();
        return instance;
    }
}
