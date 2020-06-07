package stringpackage;

public final class StringCalculator {

    public int add(String testString) {
        int count = 0;
        int LengthofString = testString.length();

        if (LengthofString == 0) {
            return LengthofString;
        } else if (LengthofString == 1) {
            return Integer.parseInt(testString);
        }

        String[] part = testString.split(",");

        for (int i = 0; i < part.length; i++) {
            count += Integer.parseInt(part[i]);
        }
        return count;
    }
}
