package pl.gatomek;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RPNTest {
    @ParameterizedTest
    @CsvSource(value = {
            "6 2 - = 4",
            "6 2 + = 8",
            "6 2 * = 12",
            "6 2 / = 3",
            "2 3 + 5 * = 25",
            "12 2 3 4 * 10 5 / + * + = 40",
            "5 1 2 + 4 * + 3 - = 14",
            },
            delimiter = '=')
    void myTest( String input, Integer expected) {
        assertEquals( expected, RPN.calc( input));
    }
}
