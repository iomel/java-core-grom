package lesson8.accounts.Ads;

public class User extends BaseEntity {

    String userName;
    String location;

    public User(long id, String userName, String location) {
        super(id);

        this.userName = userName;
        this.location = location;
    }
}
