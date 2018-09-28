package ru.job4j.list;
import java.util.List;
import java.util.ListIterator;
public class ConvertList2Array {
    /**
     * Converting List to 2D array.
     * @param list
     * @param rows
     * @return 2D array
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int listSize = list.size();
        ListIterator<Integer> listIter = list.listIterator();
        int cells = listSize / rows;
        if (list.size() % rows != 0) {
            cells++;
        }
        int[][] array = new int[rows][cells];
        int count = 0;
        for (int arrayRow = 0; arrayRow < rows; arrayRow++) {
            for (int arrayCol = 0; arrayCol < cells; arrayCol++) {
                if (count < listSize) {
                    array[arrayRow][arrayCol] = listIter.next();
                    count++;
                }
            }
        }
        return array;
    }
}

