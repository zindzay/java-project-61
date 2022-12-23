package hexlet.code.exceptions;

public class UnsupportedOperationException extends RuntimeException {
    public UnsupportedOperationException() {
        super();
    }

    public UnsupportedOperationException(String s) {
        super(s);
    }

    public UnsupportedOperationException(String s, Throwable cause) {
        super(s, cause);
    }
}
