package ru.job4j.pattern;

public class Square implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("****").append(LS);
        pic.append("*  *").append(LS);
        pic.append("*  *").append(LS);
        pic.append("****").append(LS);
        return pic.toString();
    }
}
