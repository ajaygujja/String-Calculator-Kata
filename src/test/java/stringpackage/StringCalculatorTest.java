package stringpackage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;

class StringCalculatorTest {

    static StringCalculator stringCalculator;

    @BeforeEach
    void initEach() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void testWithSpace() {
        assertEquals(0, stringCalculator.Add(""));
    }

    @Test
    void testWithOneNumber() {
        assertEquals(1, stringCalculator.Add("1"));
        assertEquals(5, stringCalculator.Add("5"));
    }

    @Test
    void testWithTwoNumbers() {
        assertEquals(3, stringCalculator.Add("1,2"));
        assertEquals(8, stringCalculator.Add("5,3"));
        assertEquals(10, stringCalculator.Add("5,5"));
    }

    @Test
    void testWithManyNumber() {
        assertEquals(15, stringCalculator.Add("1,2,3,4,5"));
        assertEquals(20, stringCalculator.Add("1,7,3,4,5"));
    }

    @Test
    void testWithNewLineNumbers() {
        assertEquals(6, stringCalculator.Add("1\n2,3"));
        assertEquals(8, stringCalculator.Add("1,4\n3"));
    }

    @Test
    void testWithSingleNegative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                stringCalculator.Add("-2");
            }

        });
        assertEquals("negatives not allowed", exception.getMessage());
    }

}
