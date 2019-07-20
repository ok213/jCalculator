import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArabicNumeral {

    private int num;

    public ArabicNumeral(String arabic){
        Pattern p = Pattern.compile("^[\\-0-9]*$");
        Matcher m = p.matcher(arabic);
        if(!m.matches())
            throw new NumberFormatException("The entered string " + arabic + " cannot be converted to a number!");
        try{
            num = Integer.parseInt(arabic);
        } catch (Exception e) {
            throw new NumberFormatException("Impossible to convert " + arabic + " to integer!");
        }
    }

    public int getNum() {
        return num;
    }
}
