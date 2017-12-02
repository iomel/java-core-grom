package final_project.demo;

import final_project.controllers.Controller;
import final_project.models.Hotel;
import final_project.models.Order;
import final_project.models.Room;
import final_project.models.User;
import final_project.utils.UserType;

import java.util.Date;

public class DemoOrder {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        User user1 = new User("Petya", "11ss", "MD", 24, UserType.USER);
        Hotel hotel1 = new Hotel("IBIS","BG", "Varna", "Maevska");
        Room room1 = new Room(3, 134,false,false, new Date(), hotel1);
        Order order1 = new Order(user1,room1, new Date(), new Date(), 134);

//        controller.addOrder(order1);
        controller.deleteOrder(1828963270);
        controller.getOrders();
    }
}
