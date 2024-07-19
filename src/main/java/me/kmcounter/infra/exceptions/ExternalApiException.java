package me.kmcounter.infra.exceptions;

public class ExternalApiException extends RuntimeException{
    public ExternalApiException() {
        super("External API Error");
    }
    public ExternalApiException(String message) {
        super(message);
    }
}
