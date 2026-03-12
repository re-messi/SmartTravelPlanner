package exceptions;

public class DuplicateEmailException extends RuntimeException{
    public DuplicateEmailException(String message) {
        super(message);
    } //unchecked exception, so we don't need to declare it in the method signature
}
