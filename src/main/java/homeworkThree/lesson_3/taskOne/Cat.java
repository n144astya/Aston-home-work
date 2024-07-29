package homeworkThree.lesson_3.taskOne;

public class Cat extends Animal {

    private static int catCount = 0;
    private final int maxRunDistance;
    private final int amountToFed;
    private boolean isFed;

    public Cat(String name, int maxRunDistance, int amountToFed) {
        super(name);
        this.maxRunDistance = maxRunDistance;
        this.amountToFed = amountToFed;
        catCount++;
    }

    public boolean isFed() {
        return isFed;
    }

    public void feed(Bowl bowl) {
        if (!isFed && bowl.getLeftFoodAmount() >= amountToFed) {
            isFed = true;
            bowl.removeFood(amountToFed);
        }
    }

    public static int getCatCount() {
        return catCount;
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
        System.out.println(super.getName() + " не умеет плавать");
    }
}
