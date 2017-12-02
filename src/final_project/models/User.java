package final_project.models;

import final_project.utils.BaseEntity;
import final_project.utils.UserType;

import java.util.Random;

public class User implements BaseEntity, Comparable<User>{

    private long id;
    private String userName;
    private String password;
    private String country; // May be ENAM will be more useful here?
    private int age;
    private UserType userType;

    public User(String userName, String password, String country, int age, UserType userType) {
        long newId = new Random().nextInt();
        this.id = newId > 0 ? newId : newId * (-1);
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.age = age;
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public UserType getUserType() {
        return userType;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return id +"," + userName +"," + password + "," + country + "," + age + "," + userType + "\n";
    }

    public int compareTo(User other){
       return Long.compare(this.getId(),other.getId());
    }

    public static User stringToObject(String userString){
        String[] userParams = userString.split(",");

        long id = Long.parseLong(userParams[0]);
        String userName = userParams[1];
        String password = userParams[2];
        String country = userParams[3];
        int age = Integer.parseInt(userParams[4]);
        UserType userType = UserType.valueOf(userParams[5]);
        User user = new User(userName, password, country, age, userType);
        user.setId(id);
        return user;
    }

}
