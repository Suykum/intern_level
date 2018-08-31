package ru.job4j.max;
/**
 * @author
 * @version $Id$
 * @since 0.1
 */

public class Max {
    /**
     * Maximum value of two digits.
     * @param first, first digit.
     * @param second, second digit.
     * @return max.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    public int max(int first, int second, int third) {
        return max(third, (max(first, second)));
    }

}
