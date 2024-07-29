package homeworkThree.lesson_3.taskOne;

public class Dog extends Animal {
    private static int dogCount = 0;

    private final int maxRunDistance;
    private final int maxSwimDistance;

    public Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name);
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;

        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(super.getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println("Слишком большая дистанция. " + super.getName() + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println(super.getName() + " проплыл " + distance + " м.");
        } else {
            System.out.println("Слишком большая дистанция. " + super.getName() + " не может проплыть " + distance + " м.");
        }
    }
}
