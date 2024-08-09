package store.store_api.exception;

public class CustomValidationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CustomValidationException(String message) {
        super(message);
    }

    public CustomValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
