package homework.taskSix;

public class FactorialHelper {

    public long getFactorial(int n) throws FactorialException {
        if (n < 0)
            throw new FactorialException("The factorial of a negative number does not exist");
        if (n > 20)
            throw new FactorialException("The value is too big");

        if (n == 0) {
            return 1;
        } else {
            return n * getFactorial(n - 1);
        }
    }
}
