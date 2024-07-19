package me.kmcounter.infra;

import me.kmcounter.infra.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ClientNotFoundException.class)
    private ResponseEntity<RestErrorMessage> clientNotFoundHandler(ClientNotFoundException ex) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }
    @ExceptionHandler(ClientDeletionException.class)
    private ResponseEntity<RestErrorMessage> clientNotFoundHandler(ClientDeletionException ex) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
    @ExceptionHandler(ClientAlreadyExistsException.class)
    private ResponseEntity<RestErrorMessage> clientNotFoundHandler(ClientAlreadyExistsException ex) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
    @ExceptionHandler(DistanceCalculationException.class)
    private ResponseEntity<RestErrorMessage> clientNotFoundHandler(DistanceCalculationException ex) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
    @ExceptionHandler(ExternalApiException.class)
    private ResponseEntity<RestErrorMessage> clientNotFoundHandler(ExternalApiException ex) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
    @ExceptionHandler(InvalidClientDataException.class)
    private ResponseEntity<RestErrorMessage> clientNotFoundHandler(InvalidClientDataException ex) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
    @ExceptionHandler(InvalidRouteDataException.class)
    private ResponseEntity<RestErrorMessage> clientNotFoundHandler(InvalidRouteDataException ex) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
    @ExceptionHandler(RouteCreationException.class)
    private ResponseEntity<RestErrorMessage> clientNotFoundHandler(RouteCreationException ex) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
    @ExceptionHandler(RouteNotFoundException.class)
    private ResponseEntity<RestErrorMessage> clientNotFoundHandler(RouteNotFoundException ex) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }
}
