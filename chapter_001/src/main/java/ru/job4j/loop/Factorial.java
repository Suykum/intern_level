package ru.job4j.loop;
/**
 * @author
 * @version $Id$
 * @since 0.1
 */

public class Factorial {
    /**
     * Calculating a factorial of n number.
     * @param n  .
     * @return multiple of numbers between 1 and n.
     */
    public int calc(int n) {
        int multple = 1;

        for (int i = 1; i <= n; i++) {
            multple *= i;
        }
        return multple;
    }
}
