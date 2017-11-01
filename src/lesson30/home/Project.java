package lesson30.home;

public class Project {
    private long id;
    private String name;
    private Customer customer;

    public Project(long id, String name, Customer customer) {
        this.id = id;
        this.name = name;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "\nProject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customer=" + customer +
                '}';
    }
}

