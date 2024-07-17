package homeworkThree.lesson_3.taskOne;

public class Animal {

    private static int animalCount = 0;

    private String name;
    private boolean isCanSwim;
    private int runLimit;
    private int swimLimit;

    public Animal(String name, boolean isCanSwim, int runLimit, int swimLimit) {
        this.name = name;
        this.isCanSwim = isCanSwim;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;

        animalCount++;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println("Слишком большая дистанция. " + name + " не может пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (isCanSwim) {
            if (distance <= swimLimit) {
                System.out.println(name + " проплыл " + distance + " м.");
            } else {
                System.out.println("Слишком большая дистанция. " + name + " не может проплыть " + distance + " м.");
            }
        } else {
            System.out.println(name + " не умеет плавать");
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
