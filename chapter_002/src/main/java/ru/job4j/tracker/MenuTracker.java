package ru.job4j.tracker;
import java.util.ArrayList;
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> actions = new ArrayList<>();
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new Item"));
        /*this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new EditItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));*/
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }


    static class AddItem implements UserAction {
        public int key;
        public String info;
        public AddItem( int key, String info) {
            this.key = key;
            this.info = info;
        }
        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDesc());
        }

        @Override
        public String info() {
            return this.info;
        }
    }




}
