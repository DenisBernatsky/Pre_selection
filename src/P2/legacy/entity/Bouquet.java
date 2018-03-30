package P2.legacy.entity;

import java.util.ArrayList;

public class Bouquet {

    public ArrayList<Flower>  makeOneTypeFlowerList(int flowerCount, Flower flower) {
        ArrayList<Flower> bouquet = new ArrayList<Flower>();
        for (int i = 0; i < flowerCount; i++) {
            bouquet.add(flower);
        }
        return bouquet;
    }

    public int getBouquetPrice(ArrayList<Flower>  flowerList) {
        int price = 0;
        for (Flower flower : flowerList) {
            price += flower.getPrice();
        }
        return price;
    }


}
