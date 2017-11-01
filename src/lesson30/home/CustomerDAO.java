package lesson30.home;

import java.util.HashSet;
import java.util.Set;

public class CustomerDAO {

    private static Set<Customer> customers = new HashSet<>();

    public static Customer add (Customer customer){
        if (customer != null)
            customers.add(customer);
        return customer;
    }

    public static void remove (Customer c){
        customers.remove(c);
    }

    public static Customer getByName (String name){
        for(Customer cust : customers)
            if (cust != null && cust.getName().equals(name))
                return cust;
        return null;
    }

    public static Set<Customer> getCustomers() {
        return customers;
    }
}
