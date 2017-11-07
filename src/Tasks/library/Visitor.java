package Tasks.library;

import java.util.Date;
import java.util.HashSet;

public class Visitor extends User{

    private String contact;
    private Date bookReceivedDate;
    private HashSet<String> books = new HashSet<>();

    public Visitor(long id, String password, String name, String contact) {
        super(id, password, name);
        this.contact = contact;
    }

    public void getBook(String callNo){

    }

    public void returnBooks(){

    }

    @Override
    public String toString() {
        return "Visitor{" + super.toString() +
                "contact='" + contact + '\'' +
                ", getBookDate=" + bookReceivedDate +
                ", books=" + books +
                "} " ;
    }
}
