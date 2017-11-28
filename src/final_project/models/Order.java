package final_project.models;

import final_project.utils.BaseEntity;

import java.util.Date;
import java.util.Random;

public class Order implements BaseEntity, Comparable<Order> {

    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order(User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        long newId = new Random().nextInt();
        this.id = newId > 0 ? newId : newId * (-1);
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    @Override
    public int compareTo(Order o) {
        return Long.compare(this.getId(), o.getId());
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
