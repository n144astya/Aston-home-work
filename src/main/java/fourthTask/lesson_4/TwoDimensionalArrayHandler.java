package fourthTask.lesson_4;

public class TwoDimensionalArrayHandler {

    public int sum(String[][] array) throws MyArrayDataException, MyArraySizeException {

        int sum = 0;
        int rows = array.length;
        if (rows != 4) {
            throw new MyArraySizeException("Wrong array size. Expected 4x4");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Wrong array size. Expected 4x4");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Wrong element type at index ["+ i +"]["+ j +"]");
                }
            }
        }

        return sum;
    }
}
