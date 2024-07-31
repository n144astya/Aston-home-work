package homework.taskSixTestNG;

import homework.taskSix.FactorialException;
import homework.taskSix.FactorialHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialUnitTest {

    @DataProvider(name = "factorial")
    public static Object[][] primeNumbers() {
        return new Object[][] {{1, 0}, {1, 1}, {121645100408832000L, 19}, {2432902008176640000L, 20}};
    }

    @Test(dataProvider = "factorial")
    public void testFactorial(long expected, int inputNumber) throws FactorialException {
        assertEquals(expected, new FactorialHelper().getFactorial(inputNumber), "Unexpected value. Expect " + expected);
    }

    @Test(expectedExceptions = FactorialException.class, expectedExceptionsMessageRegExp = "The factorial of a negative number does not exist")
    public void testFactorialOfNegativeNumber() throws FactorialException {
        new FactorialHelper().getFactorial(-1);
    }

    @Test(expectedExceptions = FactorialException.class, expectedExceptionsMessageRegExp = "The value is too big")
    public void testFactorialTooBigValue() throws FactorialException {
        new FactorialHelper().getFactorial(21);
    }
}
