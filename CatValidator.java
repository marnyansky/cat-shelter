package cat.shelter;

import java.util.Date;

public class CatValidator {

    private StringBuilder message;

    private final String ID_ERR = "\n" + "Error! ID should be unique 8-digit number in format: "
            + "[CurrentDate YYMMDD][CatID]. Example: 20012901" + "\n";
    private final String DETAILS_ERR = "\n" + "Error! Tag code and/or color fields are too short. "
            + "Remember: description ALWAYS should be detailed" + "\n";

    public CatValidator(int id, String tagCode, String color) throws MeowException {
        message = new StringBuilder();
        checkId(id);

        if (tagCode.length() < 4 || color.length() < 2) {
            message.append(DETAILS_ERR);
        }

        if (!message.toString().isEmpty()) {
            throw new MeowException(message.toString());
        }
    }

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
