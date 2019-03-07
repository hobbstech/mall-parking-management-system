package tech.hobbs.mallparkingmanagementsystem.utils.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
