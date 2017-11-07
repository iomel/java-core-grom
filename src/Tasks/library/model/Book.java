package Tasks.library.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Book implements IdEntity{
    private long id;
    private String callNo;
    private String name;
    private String author;
    private String publisher;
    private Date addedDate;
    private int quantity;
    private int issued;
    private Set<Visitor> readers = new HashSet<>();

    public Book(String callNo, String name, String author, String publisher, Date addedDate, int quantity) {
        this.callNo = callNo;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.addedDate = addedDate;
        this.quantity = quantity;
        this.issued = 0;
        Random random = new Random();
        long newId = (long)random.nextInt();
        id = newId > 0 ? newId : newId * (-1);
    }

    public long getId() {
        return id;
    }

    public Book getBook(Visitor visitor){
        if (this.quantity > 0) {
            quantity--;
            issued++;
            readers.add(visitor);
            return this;
        } else
            System.out.println("There is no free book for the moment! Try get it later...");
        return null;
    }

    public Book returnBook(Visitor visitor){
        if (readers.contains(visitor)){
            quantity++;
            issued--;
            readers.remove(visitor);
            return this;
        } else
            System.out.println("This visitor didn't got the book! Check again carefully...");
        return null;
    }

    public String getCallNo() {
        return callNo;
    }

    public int getIssued() {
        return issued;
    }

    @Override
    public String toString() {
        String result = "Book{" +
                "id=" + id +
                ", callNo='" + callNo + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", addedDate=" + addedDate +
                ", quantity=" + quantity +
                ", issued=" + issued +
                '}';

        if (!readers.isEmpty())
            result = result + "\n Readers: " + readers.toString();

        return result;
    }


}
