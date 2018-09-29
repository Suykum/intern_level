package ru.job4j.tracker_2.tracker;

import java.util.ArrayList;
import java.util.Random;
import java.util.ListIterator;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * List для хранение заявок.
     */
    private final ArrayList<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    //private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Replacing element in items list.
     * @param id of element
     * @param item
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (Item i : items) {
            if (i.getId().equals(id)) {
                item.setId(id);
                items.set(items.indexOf(i), item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * deleting element from items array.
     * @param id
     */
    ;
    public boolean delete(String id) {
        ListIterator<Item> listIter = items.listIterator();
        boolean result = false;
        while (listIter.hasNext()) {
            if (listIter.next().getId().equals(id)) {
                listIter.remove();
                result = true;
                break;
            }
        }
        /*for (Item i : items) {
            if (i.getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }*/
        return result;
    }

    /**
     * represent all elements of items array.
     * @return
     */
    public ArrayList<Item> getAll() {
        return items;

    }

    /**
     * Finding item by name.
     * @param key
     * @return
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item i : items) {
            if (i != null && i.getName().equals(key)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * Finding item by id.
     * @param id
     * @return
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }


}


