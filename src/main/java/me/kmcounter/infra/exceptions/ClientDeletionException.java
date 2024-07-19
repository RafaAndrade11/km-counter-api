package me.kmcounter.infra.exceptions;

public class ClientDeletionException extends RuntimeException {
    public ClientDeletionException() {
        super("Client cannot be deleted!");
    }
    public ClientDeletionException(String message) {
        super(message);
    }
}
