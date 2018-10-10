package ru.job4j.sort;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Stream<User> stream = list.stream();
        BiFunction<User, User, Integer> biFunc = (user1, user2)
                -> Integer.compare(user1.getName().length(), user2.getName().length());
        return  stream.sorted(biFunc::apply).collect(Collectors.toList());
    }
    public List<User> sortByAllFields(List<User> list) {
        Stream<User> stream = list.stream();
        BiFunction<User, User, Integer> biFunc = (user1, user2)
                -> { int diff = user1.getName().compareTo(user2.getName());
            return diff != 0 ? diff : Integer.compare(user1.getAge(), user2.getAge()); };
        return stream.sorted(biFunc::apply).collect(Collectors.toList());
    }

}
