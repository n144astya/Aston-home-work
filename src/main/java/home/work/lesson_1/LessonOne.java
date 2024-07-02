package home.work.lesson_1;

import java.util.Arrays;

public class LessonOne {

    public void printThreeWords(String firstWord, String secondWord, String thirdWord) {
        System.out.println(firstWord + "\n\r" + secondWord + "\n\r" + thirdWord);
    }

    public void checkSumSign(int a, int b) {
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public Boolean sumInRange(Integer a, Integer b) {
        int sum = a + b;
        return sum > 10 && sum <= 20;
    }

    public void positiveOrNegative(Integer a) {
        if (a >= 0) {
            System.out.println(a + " - is positive number");
        } else {
            System.out.println(a + "- is negative number");
        }
    }

    public Boolean isNegative(Integer a) {
        return a < 0;
    }

    public void printTextRepeatable(String text, Integer repetitions) {
        int count = 0;
        while (count < repetitions) {
            System.out.println(text);
            count++;
        }
    }

    public Boolean isLeapYear(Integer year) {
        return (year % 400 == 0 || year % 100 != 0) && year % 4 == 0;
    }

    public byte[] mirrorArray(byte[] binaryArray) {
        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] == 1) {
                binaryArray[i] = 0;
            } else if (binaryArray[i] == 0) {
                binaryArray[i] = 1;
            }
        }
        return binaryArray;
    }

    public Integer[] generateNewArray(Integer length) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public int[] generateNewArray(int length, int initValue) {
        int[] array = new int[length];
        Arrays.fill(array, initValue);
        return array;
    }

    public Integer[] doubleArrayElementIfLess(Integer[] array, Integer less) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < less) {
                array[i] = array[i] * 2;
            }
        }
        return array;
    }

    public Integer[][] fillMatrix(Integer size) {
        Integer[][] matrix = new Integer[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else if (i == matrix[i].length - 1 - j) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }
}
