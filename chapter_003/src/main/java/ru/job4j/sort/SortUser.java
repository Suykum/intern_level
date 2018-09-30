package ru.job4j.sort;
import java.util.*;
import java.util.Comparator;
/**
 * Converting List to sorted TreeSet.
 */
public class SortUser {
    private SortedSet<User> sortedUser = new TreeSet<>();
    public Set<User> sort(List<User> list) {
        sortedUser.addAll(list);
        return sortedUser;
    }
    public User getFirts() {
      return sortedUser.first();
    }

    public User getLast() {
        return sortedUser.last();
    }
    public List<User> sortByNameLength(List<User> list) {
        Collections.sort(list, new LengthComparator());
        return list;
    }
    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new UserComparator());
        return list;
    }

}
