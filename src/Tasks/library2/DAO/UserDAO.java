package Tasks.library2.DAO;

import Tasks.library2.Utils.Role;
import Tasks.library2.model.User;

import javax.jws.soap.SOAPBinding;
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
        if (user != null && !hasDuplicate(user))
            users.add(user);
        return user;
    }

    public void delete(User user){
        if (user != null) {
            users.remove(user);
        }
    }

    public boolean hasUser(User user) {
        if(user != null) {
            for (User u : users)
                if (u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword()))
                    return true;
        }
        return false;
    }
    public HashSet<User> getUsers() {
        return users;
    }

    public HashSet<User> getUsers(Role role) {
        HashSet<User> usersWithRole = new HashSet<>();
        for (User user : users)
            if (user.getRole() == role)
                usersWithRole.add(user);
        return usersWithRole;
    }

    private boolean hasDuplicate(User user){
        for (User u : users)
            if(u.getId() == user.getId())
                return true;
        return false;
    }

}
