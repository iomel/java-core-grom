package Tasks.library;

public abstract class User implements IdEntity{
    private long id;
    private String name;
    private String password;

    public User(long id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void logout(){

    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'';
    }
}
