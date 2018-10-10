package ru.job4j.list;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Converting list with arrays into simple list.
 */
public class ConvertList {
    /**
     *
     * @param list with array.
     * @return simple list.
     */
    public List<Integer> convert(List<int[]> list) {
        Stream<Integer> stream = list.stream().flatMapToInt(x -> Arrays.stream(x)).boxed();
        return stream.collect(Collectors.toList());
    }
}
