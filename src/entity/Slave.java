package entity;

public class Slave extends Person {

    private double strange;

    public Slave() {
        super("Добби", "Добряк", 12);
        this.strange = 100;
    }

    public Slave(String name, String surname, int age, double strange) {
        super(name, surname, age);
        this.strange = strange;
    }

    @Override
    public String toString() {
        return super.toString() +
                "рабатоспособность=" + strange;
    }

    public double getStrange() {
        return strange;
    }

    public void setStrange(double strange) {
        this.strange = strange;
    }

}
