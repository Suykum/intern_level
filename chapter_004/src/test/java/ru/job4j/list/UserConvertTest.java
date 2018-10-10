package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenIdthenName() {
        UserConvert map = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(111, "Bob", "Berlin"));
        list.add(new User(222, "Anna", "London"));
        list.add(new User(333, "Sasha", "Moskow"));
        map.process(list);
        System.out.println(map.getUser(222).getName());
        System.out.println(map.getUser(222).getCity());
        String result = map.getUser(222).getName();
        assertThat(result, is("Anna"));
    }
}
