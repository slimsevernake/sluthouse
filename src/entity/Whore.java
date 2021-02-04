package entity;

public class Whore extends Person {

    private double price;

    public Whore() {
        super("Нэлка", "Ебанутая", 12);
        this.price = 2.0;
    }

    public Whore(String name, String surname, int age, double price) {
        super(name, surname, age);
        this.price = price;
    }

}
