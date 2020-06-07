package stringpackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

class StringCalculatorTest {

    static StringCalculator stringCalculator;

    @BeforeEach
    void initEach() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void testWithSpace() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void testWithOneNumber() {
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(5, stringCalculator.add("5"));
    }

    @Test
    void testWithTwoNumbers() {
        assertEquals(3, stringCalculator.add("1,2"));
        assertEquals(8, stringCalculator.add("5,3"));
        assertEquals(10, stringCalculator.add("5,5"));
    }
}
