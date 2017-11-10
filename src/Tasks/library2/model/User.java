package Tasks.library2.model;

import Tasks.library2.Utils.Role;

import java.util.HashSet;

public class User {
    private long id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String city;
    private String contact;
    private boolean active = false;
    private Role role;
    private HashSet<Book> books;

    public User(long id, String name, String password, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        if (role == Role.Visitor)
            books = new HashSet<>();
    }

    public boolean isActive() {
        return active;
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

    public void setActive(boolean active) {
        this.active = active;
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        if (book != null)
            books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' + '}';
    }
}
