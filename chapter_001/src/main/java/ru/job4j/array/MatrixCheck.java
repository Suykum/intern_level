package ru.job4j.array;

/**
 * @author Suykum
 * @version
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * Checking two diagonals of square 2D matrix for monolithic elements.
     * @param data, two dimensional array.
     * @return, elements of diagonal are same or not.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean temp = data[0][0];
        boolean temp1 = data[0][data[0].length - 1];
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != temp || data[i][data.length - 1 - i] != temp1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
