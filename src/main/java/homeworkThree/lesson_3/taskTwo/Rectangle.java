package homeworkThree.lesson_3.taskTwo;

public class Rectangle extends AbstractShape {
    private final double length;
    private final double width;

    public Rectangle(String fillColor, String borderColor, double length, double width) {
        super(fillColor, borderColor);
        this.length = length;
        this.width = width;
    }

    @Override
    public double square() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}
