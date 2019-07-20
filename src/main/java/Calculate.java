import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {

    private int result;
    private boolean isArabic;

    public Calculate(String str){
        String [] arrStr = str.split(" ");
        if(arrStr.length != 3)
            throw new IllegalArgumentException("Wrong input!");

        String msg = checkInput(arrStr);
        if ("arabic".equals(msg)) {
            result(new ArabicNumeral(arrStr[0]), new ArabicNumeral(arrStr[2]), arrStr[1]);
        } else if ("roman".equals(msg)) {
            result(new RomanNumeral(arrStr[0]), new RomanNumeral(arrStr[2]), arrStr[1]);
        } else {
            throw new IllegalArgumentException(msg);
        }
    }

    // проверяет строку на только арабские или только римские цифры и знак
    private String checkInput(String [] arrStr){
        Pattern patternArabicNum = Pattern.compile("^[\\-0-9]*$");
        Pattern patternAction = Pattern.compile("[\\+\\-\\*\\/]");
        Pattern patternRomanNum = Pattern.compile("^[I,V,X,L,C,D,M]*$");

        Matcher matcherArg0 = patternAction.matcher(arrStr[1]);
        if(!matcherArg0.matches())
            throw new IllegalArgumentException("I can't calculate " + arrStr[1]);

        matcherArg0 = patternArabicNum.matcher(arrStr[0]);
        Matcher matcherArg2 = patternArabicNum.matcher(arrStr[2]);
        if(matcherArg0.matches() && matcherArg2.matches())
            return "arabic";

        matcherArg0 = patternRomanNum.matcher(arrStr[0]);
        matcherArg2 = patternRomanNum.matcher(arrStr[2]);
        if(matcherArg0.matches() && matcherArg2.matches())
            return "roman";

        return "Unknown types of operands " + arrStr[0] + " and " + arrStr[2];
    }

    private void result(ArabicNumeral lOperand, ArabicNumeral rOperand, String action){
        if ("+".equals(action)) {
            result = lOperand.getNum() + rOperand.getNum();
        } else if ("-".equals(action)) {
            result = lOperand.getNum() - rOperand.getNum();
        } else if ("*".equals(action)) {
            result = lOperand.getNum() * rOperand.getNum();
        } else if ("/".equals(action)) {
            if (rOperand.getNum() == 0)
                throw new IllegalArgumentException("It is impossible to divide by 0!");
            result = lOperand.getNum() / rOperand.getNum();
        } else {
            throw new IllegalArgumentException("I can't calculate " + action);
        }
        isArabic = true;
    }

    private void result(RomanNumeral lOperand, RomanNumeral rOperand, String action){
        if ("+".equals(action)) {
            result = lOperand.toInt() + rOperand.toInt();
        } else if ("-".equals(action)) {
            result = lOperand.toInt() - rOperand.toInt();
        } else if ("*".equals(action)) {
            result = lOperand.toInt() * rOperand.toInt();
        } else if ("/".equals(action)) {
            if(rOperand.toInt() == 0)
                throw new IllegalArgumentException("It is impossible to divide by 0!");
            result = lOperand.toInt() / rOperand.toInt();
        } else {
            throw new IllegalArgumentException("I can't calculate " + action);
        }
        isArabic = false;
    }

    public String result(){
        if(isArabic){
            return String.valueOf(result);
        }
        return new RomanNumeral(result).toString();
    }
}
