package ru.job4j.list;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
        List<Integer> resultList = new ArrayList<>();
        ListIterator<int[]> listIter = list.listIterator();
        while (listIter.hasNext()) {
            int[] array = listIter.next();
            for (int element : array) {
                resultList.add(element);
            }

        }
        return resultList;
    }
}
