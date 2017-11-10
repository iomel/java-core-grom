package Tasks.library2.DAO;

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
        if (user != null && !hasDuplicate(user))
            users.add(user);
        return user;
    }

    public void delete(User user){
        if (user != null) {
            users.remove(user);
        }
    }

    public HashSet<User> getUsers() {
        return users;
    }

    private boolean hasDuplicate(User user){
        for (User u : users)
            if(u.getId() == user.getId())
                return true;
        return false;
    }

}
