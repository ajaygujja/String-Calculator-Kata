package stringpackage;

public final class StringCalculator {

    private static final String NEGATIVE_EXCEPTION = "negatives not allowed";

    public int Add(String testString) {
        int count = 0;
        int negativeCount = 0;
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
                 * If the Integer is negative then it will increment the negativeCount
                 */
                negativeCount += 1;
            } else {
                count += Integer.parseInt(part[i]);
            }

        }

        if (negativeCount == 1) {
            /*
             * if one Integer is Negative then it will Throw exception
             */
            throw new IllegalArgumentException(NEGATIVE_EXCEPTION);

        } else if (negativeCount > 1) {
            /*
             * if more than one Integer is Negative then it will show all the integer in
             * exception message
             */
            throw new IllegalArgumentException(testString); // if whole number is -ve
        }

        return count;
    }
}
