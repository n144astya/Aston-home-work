package homeworkThree.lesson_3.taskOne;

public class Dog extends Animal {
    private static int dogCount = 0;
    public Dog(String name) {
        super(name, true, 500, 10);

        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
