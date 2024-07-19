package me.kmcounter.infra.exceptions;

public class ClientAlreadyExistsException extends RuntimeException{
    public ClientAlreadyExistsException() {
        super("Client cannot be created because already exists!");
    }
    public ClientAlreadyExistsException (String message) {
        super(message);
    }
}
