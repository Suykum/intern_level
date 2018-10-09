package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("no matter", 8));
        queue.put(new Task("middle", 3));
        System.out.println(queue.toString());
        Task result = queue.take();



        assertThat(result.getDesc(), is("urgent"));
    }
    @Test
    public void whenLowerPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("no matter", 8));
        queue.put(new Task("middle", 3));
        queue.put(new Task("no matter", 8));
        Task result = queue.last();
        System.out.println(queue.toString());
        assertThat(result.getDesc(), is("no matter"));
    }
}
