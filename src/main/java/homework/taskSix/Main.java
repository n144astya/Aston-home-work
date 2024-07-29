package homework.taskSix;

public class Main {

    public static void main(String[] args) throws FactorialException {
        FactorialHelper factorial = new FactorialHelper();

        for (int i = 0; i <= 10; i++) {
            System.out.println("!" + i + " = " + factorial.getFactorial(i));
        }
    }
}
