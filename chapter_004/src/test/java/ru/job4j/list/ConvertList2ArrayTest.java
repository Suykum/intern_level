package ru.job4j.list;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 5, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 5},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void when13ElementsThen16() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 5, 4, 5, 6, 7, 7, 7, 7, 7, 7, 8),
                4
        );
        int[][] expect = {
                {1, 2, 5, 4},
                {5, 6, 7, 7},
                {7, 7, 7, 7},
                {8, 0, 0, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void when3ElementsThen4() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 5),
                2
        );
        int[][] expect = {
                {1, 2},
                {5, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void when7ElementsThen8() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 5, 4, 5, 6, 7),
                5
        );
        int[][] expect = {
                {1, 2},
                {5, 4},
                {5, 6},
                {7, 0},
                {0, 0}
        };
        assertThat(result, is(expect));
    }

}
