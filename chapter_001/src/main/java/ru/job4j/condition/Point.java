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
    public double distanceTo(Point that) {

        double result = Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));

        return result;
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(2, 2);

        Point c = new Point(3, 5);

        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        System.out.println("x3 = " + c.x);
        System.out.println("y3 = " + c.y);

        double result = a.distanceTo(b);
        double result1 = a.distanceTo(c);

        System.out.println("Расстояние между точками А и В : " + result);
        System.out.println("Расстояние между точками А и C : " + result1);
    }
}
