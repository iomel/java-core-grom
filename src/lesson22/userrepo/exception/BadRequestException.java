package lesson22.userrepo.exception;

public class BadRequestException extends Exception {

    public BadRequestException(String message) {
        super(message);
    }
}
