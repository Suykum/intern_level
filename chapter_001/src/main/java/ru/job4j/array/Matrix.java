package ru.job4j.array;

/**
 * @author Suykum
 * @version
 * @since 0.1
 */
public class Matrix {
    /**
     * Multiplication table of 2D square array.
     * @param size, size of 2D matrix.
     * @return elements of square matrix (multiplied indexes).
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
