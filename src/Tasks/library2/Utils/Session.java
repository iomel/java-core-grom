package Tasks.library2.Utils;

import java.util.HashSet;

public class Session {
    private String sessionID;
    private HashSet<String> attributes;
    private long userId;

    public Session(String sessionID, HashSet<String> attributes, long userId) {
        this.sessionID = sessionID;
        this.attributes = attributes;
        this.userId = userId;
    }

    public HashSet<String> getAttributes() {
        return attributes;
    }

    public String getSessionID() {
        return sessionID;
    }
}
