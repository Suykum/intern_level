package ru.job4j.pattern;

public class Triangle implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   *   ").append(ls);
        pic.append("  * *  ").append(ls);
        pic.append(" *   * ").append(ls);
        pic.append("*******").append(ls);
        return pic.toString();
    }
}
