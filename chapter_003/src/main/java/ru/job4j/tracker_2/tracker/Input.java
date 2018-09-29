package ru.job4j.tracker_2.tracker;

import java.util.ArrayList;

public interface Input {
    String ask(String question);
    int ask(String question, ArrayList<Integer> range) throws MenuOutException;
}
