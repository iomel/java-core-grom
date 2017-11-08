package Tasks.library2.model;


import java.util.Date;
import java.util.HashSet;

public class Book {
    private long id;
    private String callNo;
    private String name;
    private String author;
    private String publisher;
    private Date addedDate;
    private int quantity;
    private int issued;
    private HashSet<Long> readers = new HashSet<>();

    public Book(long id, String callNo, String name, int quantity) {
        this.id = id;
        this.callNo = callNo;
        this.name = name;
        this.quantity = quantity;
        this.issued = 0;
        this.addedDate = new Date();
    }

    public long getId() {
        return id;
    }

    public String getCallNo() {
        return callNo;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public HashSet<Long> getReaders() {
        return readers;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIssued() {
        return issued;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    public void setReader(long id) {
        this.readers.add(id);
    }

    public void removeReader(long id){
        this.readers.remove(Long.valueOf(id));
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", callNo='" + callNo + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", issued=" + issued +
                '}';
    }
}
