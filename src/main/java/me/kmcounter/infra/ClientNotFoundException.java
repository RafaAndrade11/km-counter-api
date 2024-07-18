package me.kmcounter.infra;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException() {
        super("Client not found!");
    }
    public ClientNotFoundException(String message) {
        super(message);
    }
}
