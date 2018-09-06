package ru.job4j.Professions;

/**
 * Task for inheritance
 */
public class Professions {
    private String name;
    private String profession;

    public Professions(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }
    public String getProfession() {
        return profession;
    }
}
