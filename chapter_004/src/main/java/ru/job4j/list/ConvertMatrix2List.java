package ru.job4j.list;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        Stream<int[]> temp = Stream.of(array);
        Stream<Integer> flatStream = temp.flatMapToInt(x -> Arrays.stream(x)).boxed();
        return flatStream.collect(Collectors.toList());
    }
}
