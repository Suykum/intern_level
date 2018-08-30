package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turner.turn(input);
        int[] expect = new int[]{2, 6, 1, 4};
        assertThat(result, is(expect));
    }
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2, 3};
        int[] result = turner.turn(input);
        int[] expect = new int[]{3, 2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTurnArrayElevenElements() {
        Turn turner = new Turn();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] result = turner.turn(input);
        int[] expect = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }
}
