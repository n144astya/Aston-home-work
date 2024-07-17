package homeworkThree.lesson_3.taskTwo;

public abstract class AbstractShape implements Shape {

    private final String fillColor;
    private final String borderColor;

    public AbstractShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public void printShape() {
        System.out.println("Периметр: " + this.perimeter() +
                ", площадь: " + this.square() +
                ", цвет фона: " + this.fillColor +
                ", цвет границ: " + this.borderColor);
    }
}
