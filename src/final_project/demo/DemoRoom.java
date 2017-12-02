package final_project.demo;

import final_project.controllers.Controller;
import final_project.models.Hotel;
import final_project.models.Room;

import java.util.Date;

public class DemoRoom {
    public static void main(String[] args) throws Exception{
        Controller controller = new Controller();
        Hotel hotel1 = new Hotel("IBIS","BG", "Varna", "Maevska");
        Room room1 = new Room(3, 134,false,false, new Date(), hotel1);
        controller.getRooms();

        controller.addRoom(room1);
        controller.getRooms();

    }
}
