package pl.gatomek;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AlgebraicExpressionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "4 + 5 = 9",
            "6 + 2 = 8",
            "6 + 2 * 3 = 12",
            "6 * 2 + 3 = 15",
            "6 * 2 + 3 * 3 = 21",
            "2 * 3 * 2 + 3 * 3 = 21",
            "2 * 3 / 2 + 3 * 3 = 12",
            "100 / 2 / 5 = 10",
            "100 / 2 / 5 + 1 = 11",
            "1 + 100 / 2 / 5 = 11",
            "-1 + 10 = 9",
            "-1 + -10 = -11",
            "-1 - -10 = 9",
            "10 * ( 2 + 2 ) = 40",
            "( 5 + 5 ) * ( 2 + 2 ) = 40",
            "( 1 + 2 ) * ( 3 * 4 + 5 ) = 51",
            "( 1 + 2 ) * ( 3 + 4 * 5 ) = 69",
            "-5 + ( 2 * ( 3 + 4 ) ) = 9"
    },
            delimiter = '=')
    void myTest(String input, Integer expected) {
        assertEquals(expected, AlgebraicExpression.calc(input));
    }
}