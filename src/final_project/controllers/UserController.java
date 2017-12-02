package final_project.controllers;

import final_project.models.User;
import final_project.services.UserService;

public class UserController {
    private UserService userService = new UserService();
    private long userLogged = -1;

    public User registerUser(User user) throws Exception{
        return userService.registerUser(user);
    }

    public void login(String userName, String password) throws Exception {
        userLogged = userService.login(userName, password);
    }

    public void logout() {
        userLogged = -1;
    }

}
