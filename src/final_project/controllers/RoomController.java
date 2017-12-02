package final_project.controllers;

import final_project.models.Room;
import final_project.services.RoomService;
import final_project.utils.Filter;

import java.util.ArrayList;

public class RoomController {
    private RoomService roomService = new RoomService();

    public Room addRoom(Room room) throws Exception {
        return roomService.addRoom(room);
    }

    public void deleteRoom(Room room) throws Exception {
        roomService.deleteRoom(room);
    }

    public ArrayList<Room> findRooms( Filter filter) throws Exception {
        return roomService.findRooms(filter);
    }
}
