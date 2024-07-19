package me.kmcounter.infra.exceptions;

public class RouteCreationException extends RuntimeException {
    public RouteCreationException() {
        super("Invalid Route Creation Error");
    }
    public RouteCreationException(String message) {
        super(message);
    }
}