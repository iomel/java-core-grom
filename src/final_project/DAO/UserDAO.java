package final_project.DAO;

import final_project.models.User;
import final_project.utils.FilesIO;

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
                users.add(User.stringToObject(user));
        return users;
    }

}
