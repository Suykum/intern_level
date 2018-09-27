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
        ListIterator<Integer> listIter = list.listIterator();
        int listSize = list.size();
        int cells = rows;
        int[][] array = new int[rows][cells];
        int count = 0;
        for (int arrayRow = 0; arrayRow < rows; arrayRow++) {
            for (int arrayCol = 0; arrayCol < cells; arrayCol++) {
                if (count < listSize) {
                    array[arrayRow][arrayCol] = listIter.next();
                    count++;
                } else {
                    array[arrayRow][arrayCol] = 0;
                }
            }
        }
        return array;
    }
}
