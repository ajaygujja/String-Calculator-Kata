package stringpackage;

public final class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",";
    private static final String DELIMITER_PREFIX = "/";
    private static final String DELIMITER_SUFFIX = "\n";
    private static final String DELIMITER_CLOSED_BRACKET = "]";
    private static final char DELIMITER_OPEN_BRACKET = '[';
    private static final String NEGATIVE_EXCEPTION = "negatives not allowed";
    private static int involedMethod = 0;

    public int Add(String testString) {
        int count = 0;
        int negativeCount = 0;
        int LengthofString = testString.length();
        involedMethod += 1;

        if (LengthofString == 0) {
            return LengthofString;
        } else if (LengthofString == 1) {
            return Integer.parseInt(testString);
        }

        if (testString.startsWith("/")) {
            /*
             * @param Delimiter holds the delimiter value in a string
             *
             * @param New_String holds the new string which doesnt have a Delimiter
             */
            int customDelimiterStart = testString.lastIndexOf(DELIMITER_PREFIX) + 1;
            int customDelimiterEnd = testString.indexOf(DELIMITER_SUFFIX);

            if (testString.contains(String.valueOf(DELIMITER_OPEN_BRACKET))) {
                /*
                 * if the Delimter is in this Format “//[delimiter]\n”
                 */
                int closedBracket = testString.indexOf(DELIMITER_CLOSED_BRACKET);
                int openedBracket = closedBracket + 1;

                String Delimiter = testString.substring(customDelimiterStart + 1, closedBracket);
                String New_String = testString.substring(customDelimiterEnd + 1).replace(Delimiter, DEFAULT_DELIMITER);

                if (testString.charAt(closedBracket + 1) == DELIMITER_OPEN_BRACKET) {
                    /*
                     * If there is a Multiple Delimiter like this “//[delim1][delim2]\n”
                     * 
                     * @param Delimter_2 holds the Second Delimiter Value
                     */
                    String Delimiter_2 = testString.substring(openedBracket + 1, customDelimiterEnd - 1);
                    New_String = New_String.replace(Delimiter_2, DEFAULT_DELIMITER);
                }

                testString = testString.replace(testString, New_String);

            } else {
                String Delimiter = testString.substring(customDelimiterStart, customDelimiterEnd);
                String New_String = testString.substring(customDelimiterEnd + 1).replace(Delimiter, DEFAULT_DELIMITER);
                testString = testString.replace(testString, New_String);
            }

        }

        String[] part = testString.split("[\n,]");

        for (int i = 0; i < part.length; i++) {

            if (Integer.parseInt(part[i]) < 0) {
                /*
                 * If the Integer is negative then it will increment the negativeCount
                 */
                negativeCount += 1;
            } else if (Integer.parseInt(part[i]) > 1000) {
                /* ignore Integer which more than 1000 */
                continue;

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

    public int GetCalledCount() {
        /*
         * Returns how many times Add() is invoked.
         */
        return involedMethod;
    }
}
