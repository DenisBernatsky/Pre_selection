package P2.legacy.entity;

public class Violet extends Flower {

    private static int price = 34;

    public Violet(String name) {
        super(price, name);
    }

    public Violet(String name, String color) {
        super(price, name, color);
    }
}
