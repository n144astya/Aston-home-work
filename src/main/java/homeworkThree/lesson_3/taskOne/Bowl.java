package homeworkThree.lesson_3.taskOne;

public class Bowl {

    private int amountOfFood;

    public Bowl(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public void addFood(int amount) {
        amountOfFood += amount;
    }

    public void removeFood(int amount) {
        amountOfFood -= amount;
    }

    public int getLeftFoodAmount() {
        return amountOfFood;
    }

}
