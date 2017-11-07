package Tasks.library.model;

import Tasks.library.DAO.LibrarianDAO;

public class Admin extends User{


    public Admin(long id, String password, String name) {
        super(id, password, name);
    }

    public Librarian addLibrarian(Librarian librarian)
    {
        LibrarianDAO.getInstance().add(librarian);
        return librarian;
    }

    public void deleteLibrarian(long id){
        LibrarianDAO.getInstance().delete(id);
    }

    public void viewLibrarian(Librarian librarian){
        LibrarianDAO.getInstance().view();
    }

    @Override
    public String toString() {
        return "Admin{ " + super.toString() + " }";
    }
}
