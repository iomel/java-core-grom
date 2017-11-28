package final_project.models;

import final_project.utils.BaseEntity;

import java.util.Date;
import java.util.Random;

public class Room implements BaseEntity, Comparable<Room> {

    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        long newId = new Random().nextInt();
        this.id = newId > 0 ? newId : newId * (-1);
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Room o) {
        return Long.compare(this.getId(), o.getId());
    }

    @Override
    public String toString() {
        return id + "," + numberOfGuests + "," + price + "," + breakfastIncluded + "," + petsAllowed +
                "," + dateAvailableFrom.getTime() +"," + hotel.toString().replaceAll(",", ";");
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public static Room stringToObject(String roomString){
        String[] params = roomString.split(",");

        long id = Long.parseLong(params[0]);
        int numberOfGuests = Integer.parseInt(params[1]);
        double price = Double.parseDouble(params[2]);
        boolean breakfastIncluded = Boolean.parseBoolean(params[3]);
        boolean petsAllowed = Boolean.parseBoolean(params[4]);
        Date dateAvailableFrom = new Date(Long.parseLong(params[5]));
        Hotel hotel = Hotel.stringToObject(params[6].replaceAll(";", ","));
        Room room = new Room(numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, hotel);
        room.setId(id);
        return room;
    }


}
