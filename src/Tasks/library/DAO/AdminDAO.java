package Tasks.library.DAO;

import Tasks.library.model.Admin;

public class AdminDAO extends GeneralDAO<Admin> {

    private static AdminDAO instance;

    private AdminDAO() {
    }

    public static AdminDAO getInstance() {
        if(instance == null)
            instance = new AdminDAO();
        return instance;
    }
}
