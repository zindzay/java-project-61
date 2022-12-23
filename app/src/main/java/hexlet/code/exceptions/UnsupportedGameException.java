package hexlet.code.exceptions;

public class UnsupportedGameException extends RuntimeException {
    public UnsupportedGameException() {
        super();
    }

    public UnsupportedGameException(String s) {
        super(s);
    }

    public UnsupportedGameException(String s, Throwable cause) {
        super(s, cause);
    }
}
