package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean temp = data[0][0];
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != temp) {
                result = false;
                break;
            }
        }
        return result;
    }
}
