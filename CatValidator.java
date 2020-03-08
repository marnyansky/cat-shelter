import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

// TODO comments

public class CatValidator {

    private StringBuilder message;
    private LocalDate currentDate;
    private String yymmdd;

    private final String DETAILS_ERR = "\nError! Tag code and/or color fields are too short. "
            + "Remember: description ALWAYS should be detailed\n";

    public CatValidator(int id, String tagCode, String color) throws MeowException {
        message = new StringBuilder();
        currentDate = LocalDate.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        yymmdd = currentDate.toString().substring(2, 10).replaceAll("-", "");

        checkId(id);

        if (tagCode.length() < 4 || color.length() < 2) {
            message.append(DETAILS_ERR);
        }

        if (!(message.length() == 0)) {
            throw new MeowException(message.toString());
        }
    }

    private void checkId(int id) {
        int numberOfDigits = (int) Math.log10(id) + 1;
        if (numberOfDigits != 8 || !Integer.toString(id / 100).equals(yymmdd)) {
            message.append("\nError! ID should be unique 8-digit number in format: " +
                    "[CurrentDate:YYMMDD][CAT_ID]. Expected: ").append(yymmdd).append("xx\n");
        }
    }

}
