package Tasks.library2.DAO;

import Tasks.library2.Utils.Role;
import Tasks.library2.model.User;

import java.util.HashSet;

public class UserDAO {
    private static UserDAO instance;
    private HashSet<User> users = new HashSet<>();

    private UserDAO(){}

    public static UserDAO getInstance(){
        if(instance == null)
            instance = new UserDAO();
        return instance;
    }

    public User add(User user){
        if (user != null)
            users.add(user);
        return user;
    }
    public void delete(long id){
        delete(getUserById(id));
    }

    public void delete(User user){
        if (user != null)
            users.remove(user);
    }

    public void viewAll(){
        for(User user : users)
            System.out.println(user.toString());
    }

    public void viewAll(Role role){
        for(User user : users)
            if(user.getRole() == role)
                System.out.println(user.toString());
    }

    public User getAuthorisation(String name, String password){
        for (User user : users)
            if(user.getName().equals(name) && user.getPassword().equals(password))
                return user;
        return null;
    }

    public User getUserById(long id){
        for (User user : users)
            if (user.getId() == id)
                return user;
        return null;
    }

}
