package Tasks.library.DAO;

import Tasks.library.model.Visitor;

public class VisitorDAO extends GeneralDAO<Visitor> {

    private static VisitorDAO instance;

    private VisitorDAO() {
    }

    public static VisitorDAO getInstance() {
        if (instance == null)
            instance = new VisitorDAO();
        return instance;
    }
}
