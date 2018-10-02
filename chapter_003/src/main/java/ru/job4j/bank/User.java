package ru.job4j.bank;

public class User {
    private String name;
    private String passport;
    public User(String name, String passport) {
        this.setName(name);
        this.setPassport(passport);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
   /* public boolean eqauls() {

    }
    public int hashCode() {

        return 0;
    }*/

}
