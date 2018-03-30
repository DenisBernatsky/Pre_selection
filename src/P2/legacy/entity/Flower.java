package P2.legacy.entity;

import P2.legacy.flowerInterface.FlowerInterface;

public class Flower implements FlowerInterface {
    private int price;
    private String name;
    private String color;

    public Flower(int price, String name) {
        this.price = price;
        this.name = name;
    }
    public Flower(int price, String name, String color) {
        this.price = price;
        this.name = name;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
