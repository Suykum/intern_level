package ru.job4j.list;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ConvertListTest {
    @Test
    public void when4ArrayThenList1() {
        ConvertList list = new ConvertList();
        List<int[]> inputList = new ArrayList<>();
        inputList.add(new int[]{0, 0});
        inputList.add(new int[]{1, 1});
        inputList.add(new int[]{2, 2, 2});
        inputList.add(new int[]{3});
        List<Integer> expect = Arrays.asList(
                0, 0, 1, 1, 2, 2, 2, 3
        );
        List<Integer> result = list.convert(inputList);
        assertThat(result, is(expect));
    }
}
