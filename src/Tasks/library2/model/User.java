package Tasks.library2.model;

import Tasks.library2.Utils.Role;

import java.util.Date;
import java.util.HashMap;

public class User {
    private long id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String city;
    private String contact;
    private Role role;
    private HashMap<String, Date> books;

    public User(long id, String name, String password, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        if (role == Role.Visitor)
            books = new HashMap<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public HashMap<String, Date> getBooks() {
        return books;
    }

    public void addBook(String callNo, Date getBookDate){
        books.put(callNo, getBookDate);
    }

    public void removeBook(String callNo) {
        books.remove(callNo);
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
