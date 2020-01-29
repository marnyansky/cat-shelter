/**
 * Allows to throw custom exception
 */
public class MeowException extends Exception {

    /**
     * Constructor aimed to send custom message of MeowException instance to superclass (Exception)
     */
    public MeowException(String message) {
        super(message);
    }

}
