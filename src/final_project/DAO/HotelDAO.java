package final_project.DAO;

import final_project.models.Hotel;
import final_project.utils.FilesIO;

import java.io.IOException;
import java.util.TreeSet;

public class HotelDAO extends GeneralDAO<Hotel>{

    private static final String PATH_DB = "E://Test//HotelDB.txt";

    public Hotel addHotel(Hotel hotel) throws Exception {
        validate(hotel);

        add(PATH_DB, hotel);
        return hotel;
    }

    public void deleteHotel(long id) throws Exception{
        delete(PATH_DB, id);
    }

    public TreeSet<Hotel> getAll() throws Exception {
        TreeSet<Hotel> hotels = new TreeSet<>();
        String[] loadedHotels = FilesIO.readFile(PATH_DB).split("\n");

        for(String hotel : loadedHotels)
            if(!hotel.isEmpty())
                hotels.add(stringToHotel(hotel));
        return hotels;
    }

    private Hotel stringToHotel(String hotelString){
        String[] params = hotelString.split(",");

        long id = Long.parseLong(params[0]);
        String country = params[1];
        String city = params[2];
        String street = params[3];
        Hotel hotel = new Hotel(country, city, street);
        hotel.setId(id);
        return hotel;
    }

    private void validate(Hotel item) throws Exception{
        if(item == null)
            throw new IOException("validate error - hotel is NULL!");

        hasDuplicate(item.getId());

        if(item.getCountry() == null || item.getCity() == null || item.getStreet() == null)
            throw new IOException("validate error - item has NULL parameter! " + item.getClass().getSimpleName() + " ID:" + item.getId());
    }
}
