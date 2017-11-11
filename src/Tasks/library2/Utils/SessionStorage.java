package Tasks.library2.Utils;

import Tasks.library2.model.User;

import java.util.*;

public class SessionStorage {
    private static SessionStorage instance;
    private HashMap<String, Session> activeSessions = new HashMap<>();

    private SessionStorage () {}

    public static SessionStorage getInstance() {
        if (instance == null)
            return new SessionStorage();
        return instance;

    }

    public String create(User user){
        String sessionID = UUID.randomUUID().toString();
        activeSessions.put(sessionID, new Session(sessionID, setAttributes(user.getRole()), user.getId()));
        return sessionID;
    }

    public String remove(String sessionID) {
        if (sessionID != null && !sessionID.isEmpty())
            activeSessions.remove(sessionID);
        return null;
    }

    public Session getSession(String sessionID){
        return activeSessions.get(sessionID);
    }

    private HashSet<String> setAttributes(Role role){
        HashSet<String> attributes = new HashSet<>();

        switch (role) {
            case Admin:
                attributes.addAll(Arrays.asList(new String[] {"addLibrarian", "deleteLibrarian", "viewLibrarian"}));
                break;
            case Librarian:
                attributes.addAll(Arrays.asList(new String[] {"addBook", "viewAllBooks", "viewIssuedBooks", "issueBook", "returnBook", "returnAllBooks"}));
                break;
            case Visitor:
                attributes.addAll(Arrays.asList(new String[] {"issueBook", "returnBook", "returnAllBooks"}));
                break;
        }
        return attributes;
    }

}
