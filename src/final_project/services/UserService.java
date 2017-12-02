package final_project.services;

import final_project.dao.UserDAO;
import final_project.models.User;
import final_project.utils.Countries;

import java.io.IOException;
import java.util.Arrays;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) throws Exception{
        validate(user);
        return userDAO.addUser(user);
    }

    public long login(String name, String password) throws Exception {
        if (name == null || password == null)
            throw new IOException("UserService.isRegistered error - name or password is NULL!");

        for (User userInDB : userDAO.getAll())
            if (name.equals(userInDB.getUserName()) && password.equals(userInDB.getPassword()))
                return userInDB.getId();
        return -1;
    }

    private void validate(User user)throws Exception{
        nullCheck(user);
        countryCheck(user.getCountry());

        if(user.getAge() < 18)
            throw new IOException("UserService.validate error - user is under 18Y. Access denied!");
    }

    private void nullCheck(User user) throws IOException{
        if (user == null)
            throw new IOException("UserService.nullCheck error - user is NULL!");

        if (user.toString().contains("null") || user.toString().contains(",,"))
            throw new IOException("UserService.nullCheck error - user has empty parameter! User ID: " + user.getId());
    }

    private void countryCheck(String country) throws IOException{
        if(!Arrays.toString(Countries.values()).contains(country))
            throw new IOException("UserService.countryCheck error - used country is out of allowed countries scope! ::" + country);

        if (Countries.valueOf(country) == Countries.Russia || Countries.valueOf(country) == Countries.Iran)
            throw new IOException("UserService.countryCheck error - service is not allowed for the country " + country);
    }
}
