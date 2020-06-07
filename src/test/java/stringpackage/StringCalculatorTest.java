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
    }

}
