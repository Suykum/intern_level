package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        Stream<Person> stream = persons.stream();
        Predicate<Person> predicate = p -> p.getName().contains(key) || p.getSurname().contains(key)
                || p.getAddress().contains(key) || p.getPhone().contains(key);
        return stream.filter(predicate::test).collect(Collectors.toList());
    }
}

