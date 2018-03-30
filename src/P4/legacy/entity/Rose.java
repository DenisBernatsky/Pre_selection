package P4.legacy.entity;

public class Rose extends Flower {
    private int id;

    public int getId() {
        return id;
    }

    private static int price = 34;

    public Rose(String name) {
        super(price, name);
        this.id++;
    }

    public Rose(String name, String color) {
        super(price, name, color);
    }



}
