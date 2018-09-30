package ru.job4j.sort;
import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int diff = 0;
        int lim = Math.min(left.length(), right.length());
        for (int i = 0; i < lim; i++) {
            diff = Character.compare(left.charAt(i), right.charAt(i));
            if (diff != 0) {
                break;
            }
        }
        if (left.length() != right.length() && diff == 0) {
            if (left.length() < right.length()) {
                diff = -1;
            } else {
                diff = 1;
            }
        }
        return diff;
    }
}
