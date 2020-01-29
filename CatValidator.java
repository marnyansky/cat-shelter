import java.util.Date;

/**
 * Validates Cat instances through Cat ID, Cat tag code and Cat color fields validation
 */
public class CatValidator {
    /**
     * CatValidator "message" field - creates custom message (displayed on console by MeowException instance)
     * if Cat ID, Cat tag code or/and Cat color do not match special criteria {@link CatValidator#CatValidator}
     */
    private StringBuilder message;

    /**
     * predefined sub-messages for instantiating "message" field {@link CatValidator#message} if needed
     */
    private final String ID_ERR = "\n" + "Error! ID should be unique 8-digit number in format: "
            + "[CurrentDate:YYMMDD][CAT_ID]. Example: 20012901" + "\n";
    private final String DETAILS_ERR = "\n" + "Error! Tag code and/or color fields are too short. "
            + "Remember: description ALWAYS should be detailed" + "\n";

    /**
     * Constructor with internal validator of Cat ID, Cat tag code and Cat color fields
     *
     * @param id      - internal (shelter) ID of a cat, syntax: [YYMMDD][ID]
     * @param tagCode - code/ID from cat's microchip implant (IC), retrieved by using RFID device
     * @throws MeowException - thrown if Cat ID, Cat tag code or/and Cat color
     *                       do not match special criteria
     */
    public CatValidator(int id, String tagCode, String color) throws MeowException {
        message = new StringBuilder();
        checkId(id);

        if (tagCode.length() < 4 || color.length() < 2) {
            message.append(DETAILS_ERR);
        }

        if (!(message.length() == 0)) {
            throw new MeowException(message.toString());
        }
    }

    /**
     * private Method aimed to validate Cat ID
     * (by comparing its first 6 of total 8 digits to system date in format "YYMMDD")
     *
     * @param id - shelter's internal ID of a cat, syntax: [YYMMDD][ID]
     */
    private void checkId(int id) {
        int numberOfDigits = (int) Math.log10(id) + 1;
        if (numberOfDigits != 8) {
            message.append(ID_ERR);
        }

        String currentDate = new Date().toInstant().toString();
        String YYMMDD = currentDate.substring(2, 10).replaceAll("-", "");
        if (!Integer.toString(id / 100).equals(YYMMDD)) {
            message.append(ID_ERR);
        }
    }

}
