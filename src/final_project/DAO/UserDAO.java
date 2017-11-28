package final_project.DAO;

import final_project.models.User;
import final_project.utils.FilesIO;
import final_project.utils.UserType;

import java.io.IOException;
import java.util.TreeSet;

public class UserDAO extends GeneralDAO<User> {

    private static final String PATH_DB = "E://Test//UserDB.txt";

    public User addUser(User user) throws Exception {
        validateUser(user);

        add(PATH_DB, user);
        return user;
    }

    public void deleteUser(long id) throws Exception{
        TreeSet<User> users = getAll();
        String contentToWrite = "";

        hasEntity(id);

        for(User user : users)
            if(user.getId() != id)
               contentToWrite = contentToWrite.concat(user.toDBEntity());

        FilesIO.writeFile(PATH_DB,contentToWrite, false);
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

        return new User(id, userName, password, country, userType);
    }

    private void validateUser(User user) throws Exception{
        if(user == null)
            throw new IOException("validateUser error - user is NULL!");

        hasDuplicate(user.getId());

        if(user.getUserName() == null || user.getPassword() == null || user.getCountry() == null || user.getUserType() == null)
            throw new IOException("validateUser error - user has NULL parameter! User ID:" + user.getId());
    }

}
