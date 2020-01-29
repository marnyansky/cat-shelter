package cat.shelter;

/**
 * Allows to throw custom exception of the application
 */
public class MeowException extends Exception {

    /**
     * Constructor aimed to get custom message of MeowException instance
     *
     * @param message - custom message of MeowException instance
     * @see MeowException#MeowException
     */
    public MeowException(String message) {
        super(message);
    }

}
