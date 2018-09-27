package ru.job4j.search;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Putting tasks according to their priority.
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */

    public void put(Task task) {
        int index = tasks.size();
        for (Task t : tasks) {
            if (tasks.size() == 0) {
                tasks.add(task);
            } else if (task.getPriority() < t.getPriority() || task.getPriority() == t.getPriority()) {
                index = tasks.indexOf(t);
                break;
            }
        }
        tasks.add(index, task);
    }

    /**
     *
     * @return high priority task.
     */
    public Task take () {
        return this.tasks.poll();
    }

    /**
     *
     * @return the less priority task.
     */
    public Task last () {
        return this.tasks.getLast();
    }

    /**
     *
     * @return descriptions according priority.
     */
    public String toString() {
        ArrayList<String> str = new ArrayList<>();
        for (Task t : tasks) {
            str.add(t.getDesc());
        }
        return str.toString();
    }
}

