package ru.job4j.sort;

public class User implements Comparable<User> {
    private String name;
    private int age;
    public User(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(User user) {
        int diff = Integer.compare(this.age, user.age);
        return diff != 0 ? diff : this.name.compareTo(user.name);
    }
}
