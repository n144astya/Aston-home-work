package home.work;

import home.work.lesson_1.LessonOne;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        LessonOne lessonOne = new LessonOne();
        lessonOne.printThreeWords("Orange", "Banana", "Apple");
        System.out.println("--------------------------------------");
        lessonOne.checkSumSign(2, 5);
        lessonOne.checkSumSign(2, -5);
        System.out.println("--------------------------------------");
        lessonOne.printColor(-1);
        lessonOne.printColor(50);
        lessonOne.printColor(101);
        System.out.println("--------------------------------------");
        lessonOne.compareNumbers(10, 5);
        System.out.println("--------------------------------------");
        System.out.println("Is 10 + 5 sum in range 10 - 20: " + lessonOne.sumInRange(10, 5));
        System.out.println("Is 10 + 15 sum in range 10 - 20: " + lessonOne.sumInRange(10, 15));
        System.out.println("--------------------------------------");
        lessonOne.positiveOrNegative(-1);
        lessonOne.positiveOrNegative(0);
        lessonOne.positiveOrNegative(1);
        System.out.println("--------------------------------------");
        System.out.println("-1 s negative?: " + lessonOne.isNegative(-1));
        System.out.println("0 is negative?: " + lessonOne.isNegative(0));
        System.out.println("1 is negative?: " + lessonOne.isNegative(1));
        System.out.println("--------------------------------------");
        lessonOne.printTextRepeatable("some text string", 3);
        System.out.println("--------------------------------------");
        System.out.println("Is leap year: " + lessonOne.isLeapYear(2024));
        System.out.println("--------------------------------------");
        System.out.println(Arrays.toString(lessonOne.mirrorArray(new byte[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0})));
        System.out.println("--------------------------------------");
        System.out.println(Arrays.toString(lessonOne.generateNewArray(100)));
        System.out.println("--------------------------------------");
        System.out.println(Arrays.toString(lessonOne.doubleArrayElementIfLess(new Integer[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}, 6)));
        System.out.println("--------------------------------------");
        printMatrix(lessonOne.fillMatrix(5));
        System.out.println("--------------------------------------");
        System.out.println(Arrays.toString(lessonOne.generateNewArray(6, 1)));
    }

    private static void printMatrix(Integer[][] matrix) {
        for (Integer[] integers : matrix) {
            System.out.println(Arrays.toString(integers));
        }
    }
}
