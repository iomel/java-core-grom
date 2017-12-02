package final_project.services;

import final_project.dao.RoomDAO;
import final_project.models.Room;

import java.io.IOException;

public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();

    public Room addRoom(Room room) throws Exception {
        validate(room);
        return roomDAO.addRoom(room);
    }

    public void deleteRoom(Room room) throws Exception {
        if(room != null)
            roomDAO.deleteRoom(room.getId());
    }

    private void validate(Room room)throws Exception {
        if (room == null)
            throw new IOException("RoomService.validate error - room is NULL!");

        if (room.toString().contains("null") || room.toString().contains(",,"))
            throw new IOException("RoomService.validate error - room has empty parameter! Room ID: " + room.getId());
    }

}
