package ru.job4j.sort;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortedUserTest {
    SortUser userTreeSet = new SortUser();
    @Before
    public void beforeTest() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Anna", 35));
        users.add(new User("Sasha", 34));
        users.add(new User("Bob", 45));
        users.add(new User("Nicke", 25));
        users.add(new User("Bil", 25));
        userTreeSet.sort(users);
    }

    @Test
    public void whenFirst25() {
        assertThat(userTreeSet.getFirts().getAge(), is(25));
        assertThat(userTreeSet.getFirts().getName(), is("Bil"));
    }
    @Test
    public void whenLast45() {
        assertThat(userTreeSet.getLast().getAge(), is(45));
    }

}
