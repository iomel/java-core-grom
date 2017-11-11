package Tasks.library2.Utils;

import Tasks.library2.model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

public class Session {
    private String sessionID;
    private HashSet<String> attributes;
    private boolean isExpired = false;

    public Session(User user) {
        this.sessionID = UUID.randomUUID().toString();
        this.attributes = setAttributes(user.getRole());
        user.setSessionID(sessionID);
    }

    public HashSet<String> getAttributes() {
        return attributes;
    }

    public String getSessionID() {
        return sessionID;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
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
