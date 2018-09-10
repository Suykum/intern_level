package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));

    }

    @Test
    public void FindByGivenId() {
        Tracker tracker = new Tracker();
        Item first = new Item("First", "first description", 32L);
        Item second = new Item("Second", "second description", 33L);
        tracker.add(first);
        tracker.add(second);
        second.setId("33L");
        assertThat(tracker.findById("33L"), is(second));

    }
    @Test
    public void whenToDelete() {
        Tracker tracker = new Tracker();
        Item first = new Item("First", "first description", 32L);
        Item second = new Item("Second", "second description", 33L);
        Item third = new Item("Third", "third description", 34L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        System.out.println(tracker.getAll()[1].getName());
        tracker.delete(second.getId());
        assertThat(tracker.getAll()[1].getName(), is("Third"));
    }
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First", "first description", 32L);
        Item second = new Item("Second", "second description", 33L);
        Item third = new Item("Third", "third description", 34L);
        Item third1 = new Item("Third", "third1 description", 344L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(third1);
        Item[] result;
        result = tracker.findByName("Third");
        assertThat(result[0].getName(), is("Third"));
        assertThat(result[1].getName(), is("Third"));
    }
}
