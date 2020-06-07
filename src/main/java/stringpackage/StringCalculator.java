package stringpackage;

public final class StringCalculator {

    public int add(String testString) {

        int LengthofString = testString.length();
        if (LengthofString == 1) {
            return Integer.parseInt(testString);
        }

        return LengthofString;
    }

}
