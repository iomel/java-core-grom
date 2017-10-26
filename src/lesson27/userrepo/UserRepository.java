package lesson27.userrepo;

import java.util.ArrayList;

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


        for(int i = 0; i < users.size(); i++) {
            if (users.get(i) != null && users.get(i).getId() == user.getId()) {
                users.set(i, user);
                return users.get(i);
            }
        }
        return null;
    }

    public void delete(long id)
    {
        if(findById(id) != null)
            users.remove(findById(id));
    }
}