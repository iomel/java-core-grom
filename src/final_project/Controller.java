package final_project;

import final_project.DAO.UserDAO;
import final_project.models.User;

public class Controller {
    private UserDAO userDAO = new UserDAO();


    public void getUsers() throws Exception{
        System.out.println("_______________________________________________________________");
        for (User user : userDAO.getAll())
            System.out.println(user.toString());
    }

    public void addUser(User user) throws Exception {
        userDAO.addUser(user);
    }

    public void deleteUser(long id) throws Exception {
        userDAO.deleteUser(id);
    }

}
