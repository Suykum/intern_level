package ru.job4j.pattern;

public class Square implements Shape{
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("****").append("\n");
        pic.append("*  *").append("\n");
        pic.append("*  *").append("\n");
        pic.append("****").append("\n");
        return pic.toString();
    }
}
