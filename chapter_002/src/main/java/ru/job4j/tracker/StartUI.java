package ru.job4j.tracker;
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

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
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
        System.out.println("------------ All Items --------------");
        Item[] allItems = this.tracker.getAll();
        for (Item i : allItems) {
            System.out.println("Item id = " + i.getId() + ", name = " + i.getName() + ", description = " + i.getDesc());
        }
    }

    /**
     * Method for replace.
     */
    public void edit() {
        System.out.println("------------ Edit Item--------------");
        String id = this.input.ask("Enter ID of the item: ");
        String name = this.input.ask("Enter the name of the item :");
        String desc = this.input.ask("Enter the description of the item :");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println("---------------" + id + " id item is edited--------------");
    }

    /**
     * Method for deleting item.
     */
    public void deleting() {
        System.out.println("------------ Deleting item --------------");
        String id = this.input.ask("Enter ID of item: ");
        this.tracker.delete(id);
        System.out.println("----------------" + id + " id item is deleted --------------");
    }

    /**
     * Method for searching by ID.
     */
    public void searchById() {
        System.out.println("------------ Searching by ID --------------");
        String id = this.input.ask("Enter ID of the item: ");
        System.out.println("------------ Result of searching: --------------");
        Item resultOfSearch = this.tracker.findById(id);
        System.out.println("Item id = " + resultOfSearch.getId() + ", name = " + resultOfSearch.getName() + ", description = " + resultOfSearch.getDesc());
    }

    /**
     * Method for searching by name.
     */
    public void searchByName() {
        System.out.println("------------ Searching by name --------------");
        String key = this.input.ask("Enter the name of item: ");
        System.out.println("------------ Result of searching: --------------");
        Item[] resultOfSearch = this.tracker.findByName(key);
        for (Item i : resultOfSearch) {
            System.out.println("Item id = " + i.getId() + ", name = " + i.getName() + ", description = " + i.getDesc());
        }
    }

    private void showMenu() {
        System.out.println("Menu."
                + "\n0. Add new Item"
                + "\n1. Show all items"
                + "\n2. Edit item"
                + "\n3. Delete item"
                + "\n4. Find item by Id"
                + "\n5. Find items by name"
                + "\n6. Exit Program");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

