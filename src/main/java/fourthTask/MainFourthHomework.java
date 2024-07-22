package fourthTask;

import fourthTask.lesson_4.MyArrayDataException;
import fourthTask.lesson_4.MyArraySizeException;
import fourthTask.lesson_4.TwoDimensionalArrayHandler;

public class MainFourthHomework {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        TwoDimensionalArrayHandler twoDimensionalArrayHandler = new TwoDimensionalArrayHandler();
        try {
            System.out.println(twoDimensionalArrayHandler.sum(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
