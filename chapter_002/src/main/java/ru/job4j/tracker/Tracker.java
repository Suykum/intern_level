package ru.job4j.tracker;
import java.util.*;
/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return String.valueOf(System.currentTimeMillis()+RN.nextInt());
    }

    /**
     * Replacing element in items array.
     * @param id of element
     * @param item
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * deleting element from items array.
     * @param id
     */
    public void delete(String id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                int numElts = items.length - (i + 1);
                System.arraycopy(items, i + 1, items, i, numElts);
                break;
            }
        }
    }

    /**
     * represent all elements of items array.
     * @return
     */
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++) {
            result[index] = items[index];
        }
        return result;
    }

    /**
     * Finding item by name.
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int index = 0;
        for (Item item : items) {
            if(item != null && item.getName().equals(key)) {
                result[index] = item;
                index++;
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


