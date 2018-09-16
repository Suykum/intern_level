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
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "0. Add new Item"));
        this.actions.add(new ShowItems(1, "1. Show all items"));
        this.actions.add(new EditItem(2, "2. Edit item"));
        this.actions.add(new DeleteItem(3, "3. Delete item"));
        this.actions.add(new FindItemById(4, "4. Find item by Id"));
        this.actions.add(new FindItemsByName(5, "5. Find items by name"));
        this.actions.add(new ExitProgram(ui, 6, "6. Exit Program"));
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
        int key;
        String info;
        public AddItem(int key, String info) {
            this.key = key;
            this.info = info;
        }
        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new Item --------------");
            String name = input.ask("Enter a name of Item : ");
            String desc = input.ask("Enter description of Item: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId() + "-----------");

        }

        @Override
        public String info() {
            return info;
        }
    }
    static class ShowItems implements UserAction {
        int key;
        String info;
        public ShowItems(int key, String info) {
            this.key = key;
            this.info = info;
        }
        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] allItems = tracker.getAll();
            if (allItems.length != 0) {
                System.out.println("------------ All Items --------------");
                for (Item i : allItems) {
                    System.out.println(i.toString());
                }
            } else {
                System.out.println("No any Item");
            }
        }

        @Override
        public String info() {
            return info;
        }
    }
    static class EditItem implements UserAction {
        int key;
        String info;
        public EditItem(int key, String info) {
            this.key = key;
            this.info = info;
        }
        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Edit Item--------------");
            String id = input.ask("Enter ID of the item: ");
            Item resultOfSearch = tracker.findById(id);
            if (resultOfSearch != null) {
                String name = input.ask("Enter the name of the item :");
                String desc = input.ask("Enter the description of the item :");
                Item item = new Item(name, desc);
                tracker.replace(id, item);
                System.out.println("---------------" + id + " id item is edited--------------");
            } else {
                System.out.println("Item not found");
            }
        }

        @Override
        public String info() {
            return info;
        }
    }
    static class DeleteItem implements UserAction {
        int key;
        String info;
        public DeleteItem(int key, String info) {
            this.key = key;
            this.info = info;
        }
        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Deleting item --------------");
            String id = input.ask("Enter ID of item: ");
            if (tracker.delete(id)) {
                System.out.println("----------------" + id + " id item is deleted --------------");
            } else {
                System.out.println("Item not found");
            }
        }

        @Override
        public String info() {
            return info;
        }
    }
    static class FindItemById implements UserAction {
        int key;
        String info;
        public FindItemById(int key, String info) {
            this.key = key;
            this.info = info;
        }
        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Searching by ID --------------");
            String id = input.ask("Enter ID of the item: ");
            Item resultOfSearch = tracker.findById(id);
            if (resultOfSearch != null) {
                System.out.println("------------ Result of searching: --------------");
                System.out.println(resultOfSearch.toString());
            } else {
                System.out.println("Item not found");
            }
        }

        @Override
        public String info() {
            return info;
        }
    }
    static class FindItemsByName implements UserAction {
        int key;
        String info;
        public FindItemsByName(int key, String info) {
            this.key = key;
            this.info = info;
        }
        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Searching by name --------------");
            String key = input.ask("Enter the name of item: ");
            Item[] resultOfSearch = tracker.findByName(key);
            if (resultOfSearch.length != 0) {
                System.out.println("------------ Result of searching: --------------");
                for (Item i : resultOfSearch) {
                    System.out.println(i.toString());
                }
            } else {
                System.out.println("Item not found");
            }
        }
        @Override
        public String info() {
            return info;
        }
    }
    static class ExitProgram implements UserAction {
        private final StartUI input;
        int key;
        String info;
        public ExitProgram(StartUI input, int key, String info) {
            this.input = input;
            this.key = key;
            this.info = info;
        }
        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.input.stop();

        }

        @Override
        public String info() {
            return info;
        }
    }



}
