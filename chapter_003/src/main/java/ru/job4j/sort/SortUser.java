package ru.job4j.sort;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Converting List to sorted TreeSet.
 */
public class SortUser {
    private SortedSet<User> sortedUser = new TreeSet<>();
    public Set<User> sort (List<User> list) {
        sortedUser.addAll(list);
        return sortedUser;
    }
    public User getFirts() {
      return sortedUser.first();
    }

    public User getLast() {
        return sortedUser.last();
    }
}
