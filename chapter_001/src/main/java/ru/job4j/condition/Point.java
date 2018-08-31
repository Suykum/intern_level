package ru.job4j.condition;
/**
 * @author Petr Arsentev (mailto:parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Point {
    private int x;
    private int y;
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Calculating distance between two points.
     * @param that, point coordinates.
     * @return distance.
     */
    public double distanceTo(Point that) {
        double result = Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
        return result;
    }
}
