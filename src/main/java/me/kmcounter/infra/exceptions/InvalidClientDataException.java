package me.kmcounter.infra.exceptions;

public class InvalidClientDataException extends RuntimeException{
    public InvalidClientDataException() {
        super("Invalid Client Data Error");
    }
    public InvalidClientDataException(String message) {
        super(message);
    }
}
