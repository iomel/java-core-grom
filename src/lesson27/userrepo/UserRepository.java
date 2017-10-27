package lesson27.userrepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.UnaryOperator;

public class UserRepository {
    private ArrayList<User> users;

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<String> getUserNames()
    {
        if (users == null)
            return null;
        ArrayList<String> nameList = new ArrayList<>();

        for(User user : users) {
            if (user != null)
                nameList.add(user.getName());
        }
        return nameList;
    }

    public ArrayList<Long> getUserIds() {
        if (users == null)
            return null;
        ArrayList<Long> idList = new ArrayList<>();

        for (User user : users)
            if (user != null)
                idList.add(user.getId());

            return idList;
    }

    public String getUserNameById(long id)
    {
        if (users == null)
            return null;

        for(User user : users) {
            if (user != null && user.getId() == id)
                return user.getName();
        }
        return null;
    }

    public User getUserByName(String name)
    {
        if (users == null ||  name == null)
            return null;

        for(User user : users) {
            if (user != null && user.getName() == name)
                return user;
        }
        return null;
    }


    public User getUserBySessionId(String sessionId)
    {
            if (users == null || sessionId == null)
                return null;

            for (User user : users) {
                if (user != null && user.getSessionId() == sessionId)
                    return user;
            }
            return null;
    }

    public User findById(long id)
    {
        if (users == null)
            return null;

        for(User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }
        return null;
    }

    public User save(User user)
    {
        if (users == null || user == null)
            return null;

        if (findById(user.getId()) != null)
            return null;

        if (users.add(user))
            return user;

        return null;
    }

    public User update(User user)
    {
        if (users == null || user == null)
            return null;

        if (findById(user.getId()) == null)
            return null;

        UnaryOperator<User> uRep = new UnaryOperator<User>() {
            @Override
            public User apply(User testUser) {
                if (testUser == null)
                    return null;
                else
                    return (testUser.getId() == user.getId() ? user : testUser);
            }
       };

       users.replaceAll(uRep);

       return user;

    }

    public void delete(long id)
    {
        if(findById(id) != null)
            users.remove(findById(id));
    }
}