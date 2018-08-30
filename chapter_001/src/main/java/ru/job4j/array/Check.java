package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        boolean temp = data[0];

        for (int i = 1; i < data.length; i++) {
            if (data[i] == temp) {
                result = true;
            }else {
                result = false;
                break;
            }
        }
        return result;
    }
}
