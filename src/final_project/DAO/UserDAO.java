package final_project.DAO;

import final_project.models.User;
import final_project.utils.FilesIO;
import final_project.utils.UserType;

import java.io.IOException;
import java.util.TreeSet;

public class UserDAO extends GeneralDAO<User> {

    private static final String PATH_DB = "E://Test//UserDB.txt";

    public User addUser(User user) throws Exception {
        validate(user);

        add(PATH_DB, user);
        return user;
    }

    public void deleteUser(long id) throws Exception{
        delete(PATH_DB, id);
    }

    public TreeSet<User> getAll() throws Exception {
        TreeSet<User> users = new TreeSet<>();
        String[] loadedUsers = FilesIO.readFile(PATH_DB).split("\n");

        for(String user : loadedUsers)
            if(!user.isEmpty())
                users.add(stringToUser(user));
        return users;
    }

    private User stringToUser(String userString){
        String[] userParams = userString.split(",");

        long id = Long.parseLong(userParams[0]);
        String userName = userParams[1];
        String password = userParams[2];
        String country = userParams[3];
        UserType userType = UserType.valueOf(userParams[4]);
        User user = new User(userName, password, country, userType);
        user.setId(id);
        return user;
    }

    private void validate(User item) throws Exception{
        if(item == null)
            throw new IOException("validateUser error - user is NULL!");

        hasDuplicate(item.getId());

        if(item.getUserName() == null || item.getPassword() == null || item.getCountry() == null || item.getUserType() == null)
            throw new IOException("validate error - item has NULL parameter! " + item.getClass().getSimpleName() + " ID:" + item.getId());
    }

}
