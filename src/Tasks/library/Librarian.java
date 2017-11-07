package Tasks.library;

public class Librarian extends User{
    private String email;
    private String address;
    private String city;
    private String contact;

    public Librarian(long id, String password, String name, String email, String address, String city, String contact) {
        super(id, password, name);
        this.email = email;
        this.address = address;
        this.city = city;
        this.contact = contact;
    }

    public Book addBook(Book book){

        return book;
    }

    public void viewBook(Book book){

    }

    public Book issueBook(Book book){
        return book;
    }

    public void viewIssuedBooks(){

    }

    public void returnBook (Book book) {

    }

    @Override
    public String toString() {
        return "Librarian{" + super.toString() +
                "email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", contact='" + contact + '\'' +
                "} ";
    }
}
