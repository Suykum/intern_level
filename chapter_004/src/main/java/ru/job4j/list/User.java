package ru.job4j.list;

public class User {
    private Integer id;
    private String name;
    private String city;
    public User(Integer id, String name, String city) {
        this.setId(id);
        this.setName(name);
        this.setCity(city);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
