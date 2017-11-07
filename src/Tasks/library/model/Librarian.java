package Tasks.library.model;

import Tasks.library.DAO.BookDAO;

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
        if (book != null)
            BookDAO.getInstance().add(book);
        return book;
    }

    public void viewBooks(){
        BookDAO.getInstance().view();
    }

    public void issueBook(String callNo, Visitor visitor){
        if (visitor.hasExpiredBooks()) {
            System.out.println("Visitor have expired books! Can't issue new one.");
            return;
        }

        for (Book b : BookDAO.getInstance().getAll())
            if (callNo != null && b.getCallNo().equals(callNo))
                if(b.getBook(visitor) != null) {
                    visitor.getBook(callNo);
                    return;
                }

        System.out.println("Wrong book callNo" + callNo + "No such book in library!");
    }

    public void viewIssuedBooks(){
        for (Book b : BookDAO.getInstance().getAll())
            if (b.getIssued() > 0)
                System.out.println(b.toString());

    }

    public void returnBook (String callNo, Visitor visitor) {
        for (Book b : BookDAO.getInstance().getAll()) {
            if (callNo != null && b.getCallNo().equals(callNo)) {
                if(b.returnBook(visitor) != null)
                    visitor.returnBook(callNo);
                return;
            }
        }
        System.out.println("Wrong book callNo" + callNo + "No such book in library!");

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
