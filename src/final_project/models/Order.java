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

    @Override
    public String toString() {
        return id +
                "," + user.toString().replaceAll(",", ":").replace("\n","") +
                "," + room.toString().replaceAll(",", ":").replace("\n","") +
                "," + dateFrom.getTime() + "," + dateTo.getTime() +
                "," + moneyPaid + "\n";
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public static Order stringToObject(String orderString){
        String[] params = orderString.split(",");

        long id = Long.parseLong(params[0]);
        User user = User.stringToObject(params[1].replaceAll(":", ","));
        Room room = Room.stringToObject(params[2].replaceAll(":", ","));
        Date dateFrom = new Date(Long.parseLong(params[3]));
        Date dateTo = new Date(Long.parseLong(params[4]));
        double moneyPaid = Double.parseDouble(params[5]);
        Order order = new Order(user, room, dateFrom, dateTo, moneyPaid);
        order.setId(id);
        return order;
    }

}
