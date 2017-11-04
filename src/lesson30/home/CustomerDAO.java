package lesson30.home;

public class CustomerDAO extends GeneralDAO<Customer>{

    private static CustomerDAO instance;

    private CustomerDAO() {
    }

    public static CustomerDAO getInstance() {
        if (instance == null)
            instance = new CustomerDAO();
        return instance;
    }

}
