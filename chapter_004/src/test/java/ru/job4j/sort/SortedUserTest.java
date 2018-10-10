package ru.job4j.sort;

import org.junit.Before;
import org.junit.Test;
import java.util.function.BiFunction;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortedUserTest {
    SortUser sortUser = new SortUser();
    ArrayList<User> users = new ArrayList<>();
    @Before
    public void beforeTest() {
        users.add(new User("Anna", 35));
        users.add(new User("Sasha", 34));
        users.add(new User("Bob", 45));
        users.add(new User("Nicke", 25));
        users.add(new User("Bil", 25));
        users.add(new User("Bil", 33));
        sortUser.sort(users);
    }

    @Test
    public void whenFirst25() {
        assertThat(sortUser.getFirts().getAge(), is(25));
        assertThat(sortUser.getFirts().getName(), is("Bil"));
    }
    @Test
    public void whenLast45() {
        assertThat(sortUser.getLast().getAge(), is(45));
    }

    @Test
    public void whenSortByLength() {
        List<User> sortedListByLenght = sortUser.sortByNameLength(users);
        int shortestLength = sortedListByLenght.get(0).getName().length();
        assertThat(shortestLength, is(3));
        System.out.println("Sorting by name lenght");
        for (User u : sortedListByLenght) {
            System.out.println(u.getName() + " " + u.getAge());
        }

    }

    @Test
    public void whenSortByAllFields() {
        List<User> sortByAll = sortUser.sortByAllFields(users);
        System.out.println("Sorting by All field");
        for (User u : sortByAll) {
            System.out.println(u.getName() + " " + u.getAge());
        }
    }
}
