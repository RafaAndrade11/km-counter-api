package me.kmcounter.infra.exceptions;

public class InvalidRouteDataException extends RuntimeException {
    public InvalidRouteDataException() {
        super("Invalid Route Data Error");
    }
    public InvalidRouteDataException(String message) {
        super(message);
    }
}
