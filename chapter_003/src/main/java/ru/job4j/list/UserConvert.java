package ru.job4j.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Converting List to HashMap.
 */
public class UserConvert {
    HashMap<Integer, User> users = new HashMap<>();
    public HashMap<Integer, User> process(List<User> list) {
        for (User u : list) {
            users.put(u.getId(), u);
        }
        return users;
    }
    public User getUser(Integer id) {
        return users.get(id);
    }
}
