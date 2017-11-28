package final_project.models;

import final_project.utils.BaseEntity;
import final_project.utils.UserType;

import java.util.Random;

public class User implements BaseEntity, Comparable<User>{

    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User(String userName, String password, String country, UserType userType) {
        long newId = new Random().nextInt();
        this.id = newId > 0 ? newId : newId * (-1);
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return id +"," + userName +"," + password + "," + country + "," + userType + "\n";
    }

    public int compareTo(User other){
       return Long.compare(this.getId(),other.getId());
    }

}
