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
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                index = i;
                break;
            }
        }
        tasks.add(index, task);
    }

    /**
     *
     * @return high priority task.
     */
    public Task take() {
        return this.tasks.poll();
    }

    /**
     *
     * @return the less priority task.
     */
    public Task last (){
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

