package homework.taskSixJunit;

import org.junit.jupiter.api.Test;
import homework.taskSix.FactorialException;
import homework.taskSix.FactorialHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FactorialUnitTest {

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "1, 1",
            "121645100408832000, 19",
            "2432902008176640000, 20"
    })
    public void testFactorial(long expected, int inputNumber) throws FactorialException {
        assertEquals(expected, new FactorialHelper().getFactorial(inputNumber), "Unexpected value. Expect " + expected);
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        FactorialException thrown = assertThrows(FactorialException.class, () -> new FactorialHelper().getFactorial(-1));
        assertTrue(thrown.getMessage().contains("The factorial of a negative number does not exist"), "Unexpected message. Expect: 'The factorial of a negative number does not exist'");
    }
    @Test
    public void testFactorialOfTooBigValue() {
        FactorialException thrown = assertThrows(FactorialException.class, () -> new FactorialHelper().getFactorial(21));
        assertTrue(thrown.getMessage().contains("The value is too big"), "Unexpected message. Expect: 'The value is too big'");
    }
}
