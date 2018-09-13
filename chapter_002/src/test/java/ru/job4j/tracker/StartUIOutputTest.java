package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StartUIOutputTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    Tracker tracker = new Tracker();

    Item[] items = {(new Item("test1", "test2")),
                    (new Item("test2", "desc2")),
                    (new Item("test3", "desc3"))};
    @Before
    public void addItems() {
        System.out.println("Before method.");
        tracker.add(items[0]);
        tracker.add(items[1]);
        tracker.add(items[2]);
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void afterTest() {
        System.setOut(this.stdout);
        System.out.println("After method.");
    }

    @Test
    public void whenGettingAllItems() {
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(items));
    }
    @Test
    public void whenDeleteItem() {
        Input input = new StubInput(new String[]{"3", "789", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is("Item not found"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Input input = new StubInput(new String[]{"2", items[0].getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is("test replace"));
    }
}

