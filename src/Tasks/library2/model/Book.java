package Tasks.library2.model;


import java.util.Date;
import java.util.Random;

public class Book {
    private long id;
    private String callNo;
    private String name;
    private String author;
    private String publisher;
    private Date addedDate;
    private Date issuedDate;
    private boolean issued = false;
    private User reader;

    public Book(String callNo, String name) {
        Random rand = new Random();
        long newId = rand.nextLong();
        this.id = newId>0 ? newId : newId*(-1);
        this.callNo = callNo;
        this.name = name;
        this.addedDate = new Date();
    }

    public String getCallNo() {
        return callNo;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public User getReader() {
        return reader;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
        this.issuedDate = issued ? new Date() : null;
    }

    public void setReader(User reader) {
        this.reader = reader;
    }

    public void dropReader(){this.reader = null;}

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", callNo='" + callNo + '\'' +
                ", name='" + name + '\'' +
                ", issued=" + issued +
                '}';
    }
}
