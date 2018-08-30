package ru.job4j.loop;

/**
 * @author
 * @version $Id$
 * @since 0.1
 */

public class Counter {
    /**
     * Sum of even numbers ranged between start and finish.
     * @param start, first number of range.
     * @param finish, last number of range.
     * @return sum of even numbers.
     */

    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
