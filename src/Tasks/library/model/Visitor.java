package Tasks.library.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Visitor extends User{

    private String contact;
    private HashMap<String, Date> books = new HashMap<>();

    public Visitor(long id, String password, String name, String contact) {
        super(id, password, name);
        this.contact = contact;
    }

    public void getBook(String callNo){
        books.put(callNo, new Date());
    }

    public void returnBook(String callNo){
        books.remove(callNo);
    }

    public boolean hasExpiredBooks(){
        Date today = new Date();
        long diff;
        for(Map.Entry<String, Date> book : books.entrySet()){
            diff = today.getTime() - book.getValue().getTime();
            if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) >= 30)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Visitor{" + super.toString() +
                "contact='" + contact + '\'' +
                ", books=" + books +
                "} " ;
    }
}
