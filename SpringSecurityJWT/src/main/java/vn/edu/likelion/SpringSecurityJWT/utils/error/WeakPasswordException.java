package vn.edu.likelion.SpringSecurityJWT.utils.error;

public class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}
