package ru.job4j.sort;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        int diff = u1.getName().compareTo(u2.getName());
        return diff != 0 ? diff : Integer.compare(u1.getAge(),u2.getAge());
    }
}
