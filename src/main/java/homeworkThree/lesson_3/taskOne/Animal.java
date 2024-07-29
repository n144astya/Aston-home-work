package homeworkThree.lesson_3.taskOne;

public abstract class Animal {

    private static int animalCount = 0;

    private final String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getAnimalCount() {
        return animalCount;
    }
}
