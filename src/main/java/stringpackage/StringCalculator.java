package stringpackage;

public final class StringCalculator {

    private static final String NEGATIVE_EXCEPTION = "negatives not allowed";

    public int Add(String testString) {
        int count = 0;
        int LengthofString = testString.length();

        if (LengthofString == 0) {
            return LengthofString;
        } else if (LengthofString == 1) {
            return Integer.parseInt(testString);
        }

        String[] part = testString.split("[\n,]");

        for (int i = 0; i < part.length; i++) {

            if (Integer.parseInt(part[i]) < 0) {
                /*
                 * If the Number is negative it will throw Exception
                 */
                throw new IllegalArgumentException(NEGATIVE_EXCEPTION);
            } else {
                count += Integer.parseInt(part[i]);
            }

        }
        return count;
    }
}
