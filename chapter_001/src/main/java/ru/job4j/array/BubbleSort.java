package ru.job4j.array;

/**
 * @author Suykum
 * @version
 * @since 0.1
 */

public class BubbleSort {
    /**
     * Sorting array through Bubble sort algorithm.
     * @param array, input array for sorting.
     * @return sorted array
     */

    public int[] sort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array [j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
