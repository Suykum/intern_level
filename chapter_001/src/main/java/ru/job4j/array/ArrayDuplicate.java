package ru.job4j.array;
import java.util.Arrays;

/**
 * @author
 * @version
 * @since
 */
public class ArrayDuplicate {
    /**
     * Remove duplicated elements.
     * @param array, array with duplicates.
     * @return array with unique elements.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int outer = 0; outer < unique; outer++) {
            for (int inner = outer + 1; inner < unique; inner++) {
                if (array[outer].equals(array[inner])) {
                    array[inner] = array[unique - 1];
                    unique--;
                    inner--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
