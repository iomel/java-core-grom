package Tasks.library;

import java.util.Date;
import java.util.Random;

public class Book implements IdEntity{
    private long id;
    private String callNo;
    private String name;
    private String author;
    private String publisher;
    private Date addedDate;
    private int quantity;
    private int issued;

    public Book(String callNo, String name, String author, String publisher, Date addedDate, int quantity) {
        this.callNo = callNo;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.addedDate = addedDate;
        this.quantity = quantity;
        this.issued = 0;
        Random random = new Random();
        id=random.nextLong();
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", callNo='" + callNo + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", addedDate=" + addedDate +
                ", quantity=" + quantity +
                ", issued=" + issued +
                '}';
    }
}
