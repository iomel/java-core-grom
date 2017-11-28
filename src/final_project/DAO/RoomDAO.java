package final_project.DAO;

import final_project.models.Room;
import final_project.utils.FilesIO;

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
                rooms.add(Room.stringToObject(room));
        return rooms;
    }

}
