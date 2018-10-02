package ru.job4j.bank;

public class Account {
    private double value;
    private String requisites;
    public Account(double value, String requisites) {
        this.setValue(value);
        this.setRequisites(requisites);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }
}
