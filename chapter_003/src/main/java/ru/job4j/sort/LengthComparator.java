package ru.job4j.sort;

import java.util.Comparator;

public class LengthComparator implements Comparator<User> {
        @Override
    public int compare(User user1, User user2) {
        return user1.getName().length() - user2.getName().length();
    }

}
