package final_project;

import final_project.DAO.HotelDAO;
import final_project.DAO.OrderDAO;
import final_project.DAO.RoomDAO;
import final_project.DAO.UserDAO;
import final_project.models.Hotel;
import final_project.models.Order;
import final_project.models.Room;
import final_project.models.User;

public class Controller {
    private UserDAO userDAO = new UserDAO();
    private RoomDAO roomDAO = new RoomDAO();
    private HotelDAO hotelDAO = new HotelDAO();
    private OrderDAO orderDAO = new OrderDAO();

    public void getUsers() throws Exception{
        System.out.println("_______________________________________________________________");
        for (User user : userDAO.getAll())
            System.out.print(user.toString());
    }

    public void addUser(User user) throws Exception {
        userDAO.addUser(user);
    }

    public void deleteUser(long id) throws Exception {
        userDAO.deleteUser(id);
    }

    public void getRooms() throws Exception {
        System.out.println("_______________________________________________________________");
        for (Room room : roomDAO.getAll())
            System.out.print(room.toString());
    }
    public void addRoom(Room room) throws Exception {
        roomDAO.addRoom(room);
    }

    public void getHotels() throws Exception {
        System.out.println("_______________________________________________________________");
        for (Hotel hotel : hotelDAO.getAll())
            System.out.print(hotel.toString());
    }

    public void addHotel(Hotel hotel) throws Exception{
        hotelDAO.addHotel(hotel);
    }

    public void deleteHotel(long id) throws Exception {
        hotelDAO.deleteHotel(id);
    }

    public void getOrders() throws Exception {
        System.out.println("_______________________________________________________________");
        for (Order order : orderDAO.getAll())
            System.out.print(order.toString());
    }

    public void addOrder(Order order) throws Exception {
        orderDAO.addOrder(order);
    }

    public void deleteOrder(long id) throws Exception {
        orderDAO.deleteOrder(id);
    }
}
