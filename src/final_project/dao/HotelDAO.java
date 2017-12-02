package final_project.dao;

import final_project.models.Hotel;
import final_project.utils.FilesIO;

import java.util.TreeSet;

public class HotelDAO extends GeneralDAO<Hotel>{

    private static final String PATH_DB = "E://Test//HotelDB.txt";

    public Hotel addHotel(Hotel hotel) throws Exception {
        return add(PATH_DB, hotel);
    }

    public void deleteHotel(long id) throws Exception{
        delete(PATH_DB, id);
    }

    public TreeSet<Hotel> getAll() throws Exception {
        TreeSet<Hotel> hotels = new TreeSet<>();
        String[] loadedHotels = FilesIO.readFile(PATH_DB).split("\n");

        for(String hotel : loadedHotels)
            if(!hotel.isEmpty())
                hotels.add(Hotel.stringToObject(hotel));
        return hotels;
    }

}
