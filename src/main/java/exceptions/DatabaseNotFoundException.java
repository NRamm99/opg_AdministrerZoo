package exceptions;

public class DatabaseNotFoundException extends RuntimeException {
    public DatabaseNotFoundException() {
        super("Database not found");
    }
}
