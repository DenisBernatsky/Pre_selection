package P2.legacy.entity;

public class Rose extends Flower {
    private static int price = 50;

    public Rose(String name) {
        super(price, name);
    }

    public Rose(String name, String color) {
        super(price, name, color);
    }

}
