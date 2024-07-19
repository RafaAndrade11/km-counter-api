package me.kmcounter.infra.exceptions;

public class DistanceCalculationException extends RuntimeException{
    public DistanceCalculationException() {
        super("Calculating distance error!");
    }
    public DistanceCalculationException(String message) {
        super(message);
    }
}
