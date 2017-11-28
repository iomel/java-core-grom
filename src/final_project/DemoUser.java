package final_project;

import final_project.models.User;
import final_project.utils.UserType;

public class DemoUser {
    public static void main(String[] args) throws Exception{
        Controller controller = new Controller();
        User user1 = new User(1234, "Olga", "aaaa11", "RU", UserType.USER);
        controller.getUsers();

//        controller.addUser(user1);
//        controller.getUsers();
//        Thread.sleep(1000);

        controller.addUser(user1);
        controller.getUsers();

        Thread.sleep(10000);

        controller.deleteUser(1234);
        controller.getUsers();
    }
}
