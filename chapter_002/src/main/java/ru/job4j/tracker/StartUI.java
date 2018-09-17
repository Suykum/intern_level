package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    private static final String SHOWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    private boolean working = true;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    /*public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Enter number of Menu : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.seeAllItems();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.deleting();
            } else if (FINDBYID.equals(answer)) {
                this.searchById();
            } else if (FINDBYNAME.equals(answer)) {
                this.searchByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }

    }*/

    private int[] menuRanges = {0, 1, 2, 3, 4, 5, 6};
    public void init() throws MenuOutException {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        ArrayList<Integer> range = new ArrayList<>();
        menu.fillActions(this);

        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            //int key = Integer.valueOf(this.input.ask("Select:"));
            menu.select(input.ask("Select", menuRanges));
        } while (this.working);
    }
    public void stop() {
        this.working = false;
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Adding new Item --------------");
        String name = this.input.ask("Enter a name of Item : ");
        String desc = this.input.ask("Enter description of Item: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New Item with Id : " + item.getId() + "-----------");
    }

    /**
     * Method to see all items.
     */
    public void seeAllItems() {
        Item[] allItems = this.tracker.getAll();
        if (allItems.length != 0) {
            System.out.println("------------ All Items --------------");
            for (Item i : allItems) {
                System.out.println(i.toString());
            }
        } else {
            System.out.println("No any Item");
        }
    }

    /**
     * Method for replace.
     */
    public void edit() {
        System.out.println("------------ Edit Item--------------");
        String id = this.input.ask("Enter ID of the item: ");
        Item resultOfSearch = this.tracker.findById(id);
        if (resultOfSearch != null) {
            String name = this.input.ask("Enter the name of the item :");
            String desc = this.input.ask("Enter the description of the item :");
            Item item = new Item(name, desc);
            this.tracker.replace(id, item);
            System.out.println("---------------" + id + " id item is edited--------------");
        } else {
            System.out.println("Item not found");
        }

    }

    /**
     * Method for deleting item.
     */
    public void deleting() {
        System.out.println("------------ Deleting item --------------");
        String id = this.input.ask("Enter ID of item: ");
        if (this.tracker.delete(id)) {
            System.out.println("----------------" + id + " id item is deleted --------------");
        } else {
            System.out.println("Item not found");
        }
    }

    /**
     * Method for searching by ID.
     */
    public void searchById() {
        System.out.println("------------ Searching by ID --------------");
        String id = this.input.ask("Enter ID of the item: ");
        Item resultOfSearch = this.tracker.findById(id);
        if (resultOfSearch != null) {
            System.out.println("------------ Result of searching: --------------");
            System.out.println(resultOfSearch.toString());
        } else {
            System.out.println("Item not found");
        }
    }

    /**
     * Method for searching by name.
     */
    public void searchByName() {
        System.out.println("------------ Searching by name --------------");
        String key = this.input.ask("Enter the name of item: ");
        Item[] resultOfSearch = this.tracker.findByName(key);
        if (resultOfSearch.length != 0) {
            System.out.println("------------ Result of searching: --------------");
            for (Item i : resultOfSearch) {
                System.out.println(i.toString());
            }
        } else {
            System.out.println("Item not found");
        }
    }

    private void showMenu() {
        String ls = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append("Menu.").append(ls);
        sb.append("0. Add new Item").append(ls);
        sb.append("1. Show all items").append(ls);
        sb.append("2. Edit item").append(ls);
        sb.append("3. Delete item").append(ls);
        sb.append("4. Find item by Id").append(ls);
        sb.append("5. Find items by name").append(ls);
        sb.append("6. Exit Program").append(ls);
        System.out.println(sb.toString());
    }




        /**
         * Запускт программы.
         * @param args
         */
    public static void main(String[] args) throws MenuOutException {

        new StartUI(new ValidateInput(), new Tracker()).init();

    }
}

