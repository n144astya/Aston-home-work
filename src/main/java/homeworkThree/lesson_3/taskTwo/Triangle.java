package homeworkThree.lesson_3.taskTwo;

public class Triangle extends AbstractShape {

    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(String fillColor, String borderColor, double sideA, double sideB, double sideC) {
        super(fillColor, borderColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double square() {
        if (sideA <= 0 && sideB <= 0 && sideC <= 0) {
            return  0;
        }
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double perimeter() {
        return sideA > 0 && sideB > 0 && sideC > 0? sideA + sideB + sideC : 0;
    }
}
