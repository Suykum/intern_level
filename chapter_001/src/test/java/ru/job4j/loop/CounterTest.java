package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenEvenSum() {
        Counter count = new Counter();
        int result = count.add(2,  6);
        assertThat(result, is(12));
    }


}
