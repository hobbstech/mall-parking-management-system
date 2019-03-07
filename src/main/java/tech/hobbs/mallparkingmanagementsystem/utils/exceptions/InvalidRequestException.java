package tech.hobbs.mallparkingmanagementsystem.utils.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
