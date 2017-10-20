package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;
import lesson20.task1.exception.UserNotFoundException;

public class UserRepository {
    private User[] users = new User[10];

    public UserRepository(User[] users) {
        this.users = users;
    }

    //----- TASK 2 ---------------------

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames()
    {
        if (users == null)
            return null;
        int count = 0;
        for(User user : users)
            if(user != null)
                count++;

        String[] nameList = new String[count];
        count = 0;

        for(User user : users)
            if(user != null) {
                nameList[count] = user.getName();
                count++;
            }

        return nameList;
    }

    public long[] getUserIds()
    {
        if (users == null)
            return null;
        int count = 0;
        for(User user : users)
            if(user != null)
                count++;

        long[] idList = new long[count];
        count = 0;

        for(User user : users)
            if(user != null) {
                idList[count] = user.getId();
                count++;
            }

        return idList;
    }

    public String getUserNameById(long id)
    {
        if (users == null)
            return null;

        for (User user : users)
        {
            if (user == null)
                continue;
            else if (user.getId() == id)
                return user.getName();

        }
        return null;
    }

    // task 3 methods

    public User getUserByName(String name)
    {
        if (users == null ||  name == null)
            return null;

        for(User user : users) {
            if (user == null)
                continue;
            if (user.getName() == name)
                return user;
        }
        return null;
    }


    public User getUserBySessionId(String sessionId)
    {
            if (users == null || sessionId == null)
                return null;

            for (User user : users) {
                if (user == null)
                    continue;

                if (user.getSessionId() == sessionId)
                    return user;
            }
            return null;
    }

    // --------- Task 4 ----------

    public User findById(long id) throws UserNotFoundException {
        if (users == null)
            return null;

        for(User user : users)
            if (user != null && user.getId() == id)
                return user;
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public User save(User user) throws Exception
    {
        if(user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e)
        {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        for (int i = 0; i < users.length; i++)
        {
            if(users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        throw new InternalServerException("Not enough space to save user with id:" + user.getId() );
    }

    // ------ Task 5 -------

    public User update(User user) throws Exception
    {
        if(user == null)
            throw new BadRequestException("Can't save null user");

        findById(user.getId());

        for (int i = 0; i < users.length; i++)
            if(users[i] != null && users[i].getId() == user.getId())
                {
                    users[i] = user;
                    return users[i];
                }
        throw new InternalServerException("Unexpected error");
    }

    public void delete(long id) throws Exception
    {
        findById(id);
        for (int i = 0; i < users.length; i++)
            if(users[i] != null && users[i].getId() == id)
            {
                users[i] = null;
                break;
            }

    }
}