package starter;

public class DetailsDoesNotMatch extends AssertionError {

    public DetailsDoesNotMatch(String message, Throwable cause) {
        super(message, cause);
    }
}