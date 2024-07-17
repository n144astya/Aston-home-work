package homeworkThree.lesson_3.taskTwo;

public abstract class AbstractShape implements Shape {

    private String fillColor;
    private String borderColor;

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
