package homework.taskSixTestNG;

import homework.taskSix.FactorialException;
import homework.taskSix.FactorialHelper;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialUnitTest {

    @Test
    public void testFactorialOfZero() throws FactorialException {
        assertEquals(1, new FactorialHelper().getFactorial(0));
    }

    @Test
    public void testFactorialOfOne() throws FactorialException {
        assertEquals(1, new FactorialHelper().getFactorial(1));
    }

    @Test
    public void testFactorialOfTwo() throws FactorialException {
        assertEquals(2, new FactorialHelper().getFactorial(2));
    }

    @Test
    public void testFactorialOfFive() throws FactorialException {
        assertEquals(120, new FactorialHelper().getFactorial(5));
    }

    @Test
    public void testFactorialOfTen() throws FactorialException {
        assertEquals(3628800, new FactorialHelper().getFactorial(10));
    }

    @Test(expectedExceptions = FactorialException.class, expectedExceptionsMessageRegExp = "The factorial of a negative number does not exist")
    public void testFactorialOfNegativeNumber() throws FactorialException {
        new FactorialHelper().getFactorial(-1);
    }
}
