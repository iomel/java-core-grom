package final_project.models;

import final_project.utils.BaseEntity;

import java.util.Random;

public class Hotel implements BaseEntity, Comparable<Hotel> {

    private long id;
    private String country;
    private String city;
    private String street;

    public Hotel(String country, String city, String street) {
        long newId = new Random().nextInt();
        this.id = newId > 0 ? newId : newId * (-1);
        this.country = country;
        this.city = city;
        this.street = street;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Hotel o) {
        return Long.compare(this.getId(), o.getId());
    }

    @Override
    public String toString() {
        return id +"," + country +"," + city + "," + street + "\n";
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public static Hotel stringToObject(String hotelString){
        String[] params = hotelString.split(",");

        long id = Long.parseLong(params[0]);
        String country = params[1];
        String city = params[2];
        String street = params[3];
        Hotel hotel = new Hotel(country, city, street);
        hotel.setId(id);
        return hotel;
    }

}
