package ru.job4j.tracker_2.tracker;
public interface Input {
    String ask(String question);
    int ask(String question, int[] range) throws MenuOutException;
}
