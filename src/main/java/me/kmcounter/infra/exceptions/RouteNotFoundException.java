package me.kmcounter.infra.exceptions;

public class RouteNotFoundException extends RuntimeException{
    public RouteNotFoundException() {
        super("Route Not Found Error");
    }
    public RouteNotFoundException(String message) {
        super(message);
    }
}
