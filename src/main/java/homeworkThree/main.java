package homeworkThree;

import homeworkThree.lesson_3.taskOne.Animal;
import homeworkThree.lesson_3.taskOne.Bowl;
import homeworkThree.lesson_3.taskOne.Cat;
import homeworkThree.lesson_3.taskOne.Dog;
import homeworkThree.lesson_3.taskTwo.Circle;
import homeworkThree.lesson_3.taskTwo.Triangle;
import homeworkThree.lesson_3.taskTwo.Rectangle;
import homeworkThree.lesson_3.taskTwo.Shape;

import java.awt.*;

public class main {

    public static void main(String[] args) {
        taskOneTest();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        taskTwoTest();
    }

    public static void taskOneTest() {
        Bowl bowl = new Bowl(40);

        Cat cat_1 = new Cat("cat_1", 10);
        Cat cat_2 = new Cat("cat_2", 5);
        Cat cat_3 = new Cat("cat_3", 35);
        Cat cat_4 = new Cat("cat_4", 15);

        Cat[] cats = {cat_1, cat_2, cat_3, cat_4};

        for (Cat cat: cats) {
            cat.feed(bowl);
            System.out.println(cat.getName() + " is fed: " + cat.isFed());
        }

        Animal dog_1 = new Dog("dog_1");
        Animal dog_2 = new Dog("dog_2");
        Animal dog_3 = new Dog("dog_3");
        Animal dog_4 = new Dog("dog_4");
        Animal dog_5 = new Dog("dog_5");

        dog_5.swim(500);
        dog_4.run(600);
        cat_2.swim(20);
        cat_1.run(200);
        dog_2.run(500);

        System.out.println("Animals: " + Animal.getAnimalCount() + " Cats: " + Cat.getCatCount() + " Dogs: " + Dog.getDogCount());
    }

    public static void taskTwoTest() {
        Shape[] shapes = {
                new Circle("#FF0000", "#FF0000", 5.5),
                new Rectangle("#FF0002", "#FF0004", 5.5, 8.5),
                new Triangle("#FF0082", "#FF0006", 5.5, 5.5, 5.5)
        };
        for (Shape shape: shapes) {
            shape.printShape();
        }
    }
}
