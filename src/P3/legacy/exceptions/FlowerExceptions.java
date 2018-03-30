package P3.legacy.exceptions;

public class FlowerExceptions extends RuntimeException{

    public FlowerExceptions(String message) {
        super(message);
    }

    public FlowerExceptions(String message, Throwable cause) {
        super(message, cause);
    }

}
