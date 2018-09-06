package ru.job4j.Professions;

public class Doctor extends Professions {

    public Doctor(String name, String profession) {
        super(name, profession);
    }
    public Diagnose heal(Patient nameP) {
        Diagnose diagnose = null;
        return diagnose;
    }
}
class Patient {
    private String name;
    public Patient(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class Diagnose {
    private String nameDiagnose;
    public Diagnose(String nameD) {
        nameDiagnose = nameD;
    }
    public String getNameDiagnose() {
        return nameDiagnose;
    }
}
