package homeworkThree.lesson_3.taskOne;

public class Cat extends Animal {

    private static int catCount = 0;

    private int amountToFed;
    private boolean isFed;
    public Cat(String name, int amountToFed) {
        super(name, false, 200, 0);
        this.amountToFed = amountToFed;
        catCount++;
    }

    public boolean isFed() {
        return isFed;
    }

    public void feed(Bowl bowl) {
        if (bowl.getLeftFoodAmount() >= amountToFed) {
            isFed = true;
            bowl.removeFood(amountToFed);
        }
    }

    public static int getCatCount() {
        return catCount;
    }
}
