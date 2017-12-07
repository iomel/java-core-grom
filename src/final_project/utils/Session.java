package final_project.utils;

public class Session {
    //why do you use session inside session? should be refactored
    private static Session instance;
    private long id;

    private Session() {
    }

    public static Session getInstance() {
        if (instance == null)
            instance = new Session();
        return instance;
    }

    public static void resetSession(){
        instance.id = -1;
    }
    public long getId() {
        return id;
    }

    public static void startSession (long id) {
        if (instance != null)
            instance.id = id;
    }


}
