package ru.job4j.Professions;

public class Engineer extends Professions {

    public Engineer(String name, String profession) {
        super(name, profession);
    }
    public House build() {
        return House;
    }

}

class House {
    private String houseType;
    private String houseAddress;
    public House() {
        houseAddress = "";
        houseType = "";
    }
}
