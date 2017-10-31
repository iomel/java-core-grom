package lesson30.home.DAO;

import lesson30.home.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerDAO {

    {init();}
    private static Set<Customer> customers = new HashSet<>();

    public static Customer add (Customer c){
        customers.add(c);
        return c;
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

    private static void init(){
        Customer cust1 = new Customer("IBM");
        Customer cust4 = new Customer("Cisco");
        Customer cust2 = new Customer("GOOGLE");
        Customer cust3 = new Customer("Amazon");

        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);
        customers.add(cust4);
    }
}
