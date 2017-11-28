package final_project.DAO;

import final_project.models.Hotel;
import final_project.models.Room;
import final_project.utils.FilesIO;

import java.io.IOException;
import java.util.Date;
import java.util.TreeSet;

public class RoomDAO extends GeneralDAO<Room> {

    private static final String PATH_DB = "E://Test//RoomDB.txt";

    public Room addRoom(Room room) throws Exception {
        validate(room);

        add(PATH_DB, room);
        return room;
    }

    public void deleteRoom(long id) throws Exception{
        delete(PATH_DB, id);
    }

    public TreeSet<Room> getAll() throws Exception {
        TreeSet<Room> rooms = new TreeSet<>();
        String[] loadedRooms = FilesIO.readFile(PATH_DB).split("\n");

        for(String room : loadedRooms)
            if(!room.isEmpty())
                rooms.add(stringToRoom(room));
        return rooms;
    }

    private Room stringToRoom(String roomString){
        String[] params = roomString.split(",");

        long id = Long.parseLong(params[0]);
        int numberOfGuests = Integer.parseInt(params[1]);
        double price = Double.parseDouble(params[2]);
        boolean breakfastIncluded = Boolean.parseBoolean(params[3]);
        boolean petsAllowed = Boolean.parseBoolean(params[4]);
        Date dateAvailableFrom = new Date(Long.parseLong(params[5]));
        Hotel hotel = stringToHotel(params[6].replaceAll(":", ","));
        Room room = new Room(numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, hotel);
        room.setId(id);
        return room;
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

    private void validate(Room item) throws Exception{
        if(item == null)
            throw new IOException("validate error - hotel is NULL!");

        hasDuplicate(item.getId());

        if(item.getHotel().getCountry() == null || item.getHotel().getCity() == null || item.getHotel().getStreet() == null)
            throw new IOException("validate error - item has NULL parameter! " + item.getHotel().getClass().getSimpleName() + " ID:" + item.getId());
    }

}
