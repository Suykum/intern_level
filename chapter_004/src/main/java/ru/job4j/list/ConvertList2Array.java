package ru.job4j.list;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertList2Array {
    /**
     * Converting List to 2D array.
     * @param list
     * @param rows
     * @return 2D array
     */
    int i = 0;
    int j = 0;
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % rows != 0) {
            cells++;
        }
        int col = cells;
        int[][] array = new int[rows][col];
        list.stream().forEach(x -> {
            array[i][j++] = x;
            if (j == col) {
                i++;
                j = 0;
            }
        });
        return array;
    }
}

