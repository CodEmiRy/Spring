package pl.sda.springtraining.spring.user;

public class UserExistisException extends RuntimeException {

    public UserExistisException(String message) {
        super(message);
    }
}
