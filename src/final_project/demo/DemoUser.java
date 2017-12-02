package final_project.demo;

import final_project.controllers.Controller;
import final_project.models.User;
import final_project.utils.UserType;

public class DemoUser {
    public static void main(String[] args) throws Exception{
        Controller controller = new Controller();
        User user1 = new User("Olga", "aaaa11", "RU", 17, UserType.USER);
        controller.getUsers();

        controller.addUser(user1);
//        controller.deleteUser(1632404418);
        controller.getUsers();
    }
}
