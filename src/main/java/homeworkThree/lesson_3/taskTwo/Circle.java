package homeworkThree.lesson_3.taskTwo;

public class Circle extends AbstractShape {
    private final double radius;

    public Circle(String fillColor, String borderColor, double radius) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double square() {
        return radius > 0? Math.PI * radius * radius : 0;
    }

    @Override
    public double perimeter() {
        return radius > 0? 2 * Math.PI * radius : 0;
    }
}
